

def ids(graph, start, goal):
    """
    Iterative Deepening Depth First Search (IDS) algorithm

    Args:
        graph: A dictionary representing the graph
        start: The starting node
        goal: The goal node

    Returns:
        A list of nodes visited in IDS order, or None
        if the goal is not found
    """

    for limit in range(1, len(graph)):
        result = dls(graph, start, goal, limit)
        if result:
            return result

    return None

graph = {
    "A": ["B", "C"],
    "B": ["D", "E"],
    "C": ["F", "G"],
    "D": [],
    "E": [],
    "F": [],
    "G": []
}

print(ids(graph, "A", "G"))
