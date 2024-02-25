

def dfs(graph, start, goal):
    """
    Depth First Search (DFS) algorithm

    Args:
        graph: A dictionary representing the graph
        start: The starting node

    Returns:
        A list of nodes visited in DFS order
    """

    visited = []
    stack = [start]

    while stack:
        node = stack.pop()
        visited.append(node)
        if node == goal:
          return ('I found :', goal, 'visited :', visited)
          break
        for neighbor in graph[node][::-1]:
            if neighbor not in visited:
                stack.append(neighbor)

    return list(visited)
graph = {
    "A": ["B", "C"],
    "B": ["D", "E"],
    "C": ["F", "G"],
    "D": [],
    "E": [],
    "F": [],
    "G": []
}

print(dfs(graph, "A", 'C'))