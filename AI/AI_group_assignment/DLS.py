def dls(graph, start, goal, limit):
    """
    Depth Limited Search (DLS) algorithm

    Args:
        graph: A dictionary representing the graphc
        start: The starting node
        goal: The goal node
        limit: The depth limit

    Returns:
        A list of nodes visited in DLS order, or None
        if the goal is not found within the depth limit
    """

    visited = []
    stack = [(start, 0)]

    while stack:
        node, depth = stack.pop()
        visited.append(node)
        if node == goal:
            return list(visited)
        if depth == limit:
            continue
        for neighbor in graph[node][::-1]:
            if neighbor not in visited:
                stack.append((neighbor, depth + 1))

    return None

graph = {
    "A": ["B", "C"],
    "B": ["D", "E"],
    "C": ["F", "G"],
    "D": [],
    "E": [],
    "F": [],
    "G": ['H'],
    "H": []
}

limit = 1

print(dls(graph, "A", "F", limit))
