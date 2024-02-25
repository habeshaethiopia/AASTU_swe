#include <iostream>
#include <string>
#include <cstdlib> // for atoi function
using namespace std;

int e();
int ePrime(int);
int t();
int tPrime(int);
int f();
int i;
string input;

int main() {
    /*    grammar prodaction
      E -> TE'  
      E' -> +TE' | ε 
      T -> FT' 
      T' -> *FT' | ε 
      F -> (E) | id
    */
    i = 0;
    cout << "Enter an arithmetic expression : ";
    getline(cin, input);
    int result = e();

    if (input.length() == i) {
        cout << "\nAccepted..!!!\n";
        cout << "Result: " << result << endl;
    } else {
        cout << "\nRejected..!!!\n";
    }

    return 0;
}

void error() {
    cout << "Error happened couldn't parse!!";
    exit(0);
}

int e() {
    int termResult = t();
    int ePrimeResult = ePrime(termResult);
    return ePrimeResult;
}

int ePrime(int inheritedValue) {
    if (input[i] == '+') {
        i++;
        int termResult = t();
        int newValue = inheritedValue + termResult;
        int ePrimeResult = ePrime(newValue);
        return ePrimeResult;
    } else {
        return inheritedValue;
    }
}

int t() {
    int factorResult = f();
    int tPrimeResult = tPrime(factorResult);
    return tPrimeResult;
}

int tPrime(int inheritedValue) {
    if (input[i] == '*') {
        i++;
        int factorResult = f();
        int newValue = inheritedValue * factorResult;
        int tPrimeResult = tPrime(newValue);
        return tPrimeResult;
    } else {
        return inheritedValue;
    }
}

int f() {
    if (input[i] == '(') {
        i++;
        int eResult = e();
        if (input[i] == ')') {
            i++;
            return eResult;
        } else {
            error();
        }
    } else if (isdigit(input[i])) {
        // Convert the character to integer using atoi
        int value = atoi(&input[i]);
        while (isdigit(input[i])) {
            i++;
        }
        return value;
    } else {
        error();
        return 0; // to avoid compilation warning
    }
    return 0;
}