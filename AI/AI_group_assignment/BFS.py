from collections import deque
def bfs(graph, start, goal):
    """
    Breadth First Search (BFS) algorithm

    Args:
        graph: A dictionary representing the graph
        start: The starting node

    Returns:
        A list of nodes visited in BFS order
    """

    visited = []
    queue = deque([start])

    while queue:
        node = queue.popleft()
        visited.append(node)
        if node == goal:
          return ('I found :', goal, 'visited:', visited)
          break
        for neighbor in graph[node]:
            if neighbor not in visited:
                queue.append(neighbor)

    return 'not found', 'visited: ',list(visited)
graph = {
    "A": ["B", "C"],
    "B": ["D", "E"],
    "C": ["F", "G"],
    "D": [],
    "E": [],
    "F": [],
    "G": []
}

print(bfs(graph, "A", 'C'))
