#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <set>
#include <cctype>

using namespace std;

enum TokenType {
    Identifier,
    Keyword,
    Literal,
    Operator,
    SpecialSymbol,
    Comment,
    Invalid
};

bool isValidIdentifier(const string& str) {
    if (!isalpha(str[0]) && str[0] != '_')
        return false;

    for (string::size_type i = 1; i < str.length(); ++i) {
        if (!isalnum(str[i]) && str[i] != '_')
            return false;
    }

    return true;
}

bool isKeyword(const string& str) {
    static set<string> dataTypes = { "auto", "break","bool", "case", "catch", "class", "const", "continue", "default", "delete", "do", "double",
        "else", "enum", "explicit", "export", "extern", "false", "float", "for", "friend", "if", "inline",
        "int", "long", "namespace", "new", "operator", "private", "protected", "public", "return", "short",
        "signed", "sizeof", "static", "struct", "switch", "template", "this", "throw", "true", "try",
        "typedef", "typeid", "typename", "main", "unsigned", "using", "include", "void", "volatile", "while"};

    return dataTypes.find(str) != dataTypes.end();
}

bool isLiteral(const string& str) {
    istringstream iss(str);
    float f;
    iss >> noskipws >> f;
    return !iss.fail() && iss.eof();
}

bool isOperator(char c) {
    static set<char> operators = {'+', '-', '*', '/', '=', '>', '<', '&', '|', '!', '%', '^', '~', '?', ':', '.'};

    return operators.find(c) != operators.end();
}

bool isSpecialSymbol(char c) {//punctuator
    static set<char> symbols = {'(', ')', '{', '}', '[', ']', ',', '.', ';', ':', '@', '#', '$', '_', '`'};

    return symbols.find(c) != symbols.end();
}

bool isComment(const string& str) {
    return str.substr(0, 2) == "//" || (str.substr(0, 2) == "/*" && str.find("*/") != string::npos);
}

bool isUnexpectedChar(char c) {
    return !isalnum(c) && !isspace(c) && !isOperator(c) && !isSpecialSymbol(c) && c != '"' && c != '/' && c != '*';
}

TokenType getTokenType(const vector<string>& tokens, vector<string>::size_type index) {
    if (isValidIdentifier(tokens[index])) {
        if (isKeyword(tokens[index])) {
            return Keyword;
        } else {
            return Identifier;
        }
    } else if (isLiteral(tokens[index])) {
        return Literal;
    } else if (isOperator(tokens[index][0])) {
        return Operator;
    } else if (isSpecialSymbol(tokens[index][0])) {
        return SpecialSymbol;
    } else if (isComment(tokens[index])) {
        return Comment;
    } else {
        return Invalid;
    }
}

vector<string> tokenizeStatement(const string& statement) {
    vector<string> tokens;
    string currentToken;
    bool insideStringLiteral = false;
    bool insideSingleLineComment = false;
    bool insideMultiLineComment = false;

    for (string::size_type i = 0; i < statement.length(); ++i) {
        char c = statement[i];

        if (isUnexpectedChar(c)) {
            cerr << "Error: Unexpected character '" << c << "' at position " << i + 1 << endl;
            return tokens;
        }

        if (insideMultiLineComment) {
            if (statement.substr(i, 2) == "*/") {
                insideMultiLineComment = false;
                ++i; 
            }
        } else if (insideSingleLineComment) {
            if (c == '\n' || c == '\r') {
                insideSingleLineComment = false;
            }
        } else if (c == '"' && !insideMultiLineComment && !insideSingleLineComment) {
            insideStringLiteral = !insideStringLiteral;
            currentToken += c;
        } else if (insideStringLiteral) {
            if (c == '\\') { 
                currentToken += c;
                if (i + 1 < statement.length()) {
                    ++i; 
                    currentToken += statement[i];
                }
            } else {
                currentToken += c;
            }
        } else if (isComment(statement.substr(i))) {
            if (statement.substr(i, 2) == "//") {
                insideSingleLineComment = true;
            } else if (statement.substr(i, 2) == "/*") {
                insideMultiLineComment = true;
            }
        } else if (isspace(c)) {
            
            while (i + 1 < statement.length() && isspace(statement[i + 1])) {
                ++i;
            }

            if (!currentToken.empty()) {
                tokens.push_back(currentToken);
                currentToken.clear();
            }
        } else if (isSpecialSymbol(c) || isOperator(c)) {
            if (!currentToken.empty()) {
                tokens.push_back(currentToken);
                currentToken.clear();
            }
            tokens.push_back(string(1, c));
        } else {
            currentToken += c;
        }
    }

    if (!currentToken.empty())
        tokens.push_back(currentToken);

    return tokens;
}

int main() {
    string statement;

    do {
        cout << "Input a statement: ";
        getline(cin, statement);

        if (statement.empty()) {
            cerr << "Empty statement." << endl;
        }
    } while (statement.empty());

    cout << "Token\t\t\tToken Type" << endl;
    cout << endl;

    vector<string> tokens = tokenizeStatement(statement);

    if (tokens.empty()) {
        cerr << "Failed to tokenize your statement." << endl;
        return 1;
    }

    for (vector<string>::size_type i = 0; i < tokens.size(); ++i) {
        string token = tokens[i];
        TokenType type = getTokenType(tokens, i);

        cout << token << "\t\t\t";

        switch (type) {
            case Identifier:
                cout << "Identifier";
                break;
            case Keyword:
                cout << "Keyword";
                break;
            case Literal:
                cout << "Literal";
                break;
            case Operator:
                cout << "Operator";
                break;
            case SpecialSymbol:
                cout << "Special Symbol";
                break;
            case Comment:
                cout << "Comment";
                break;
            case Invalid:
                cout << "Invalid Token";
                break;
        }

        cout << endl;
    }

    return 0;
}
