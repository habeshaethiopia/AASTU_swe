import heapq
import math

def ucs(graph, start, goal):
    """
    Uniform Cost Search (UCS) algorithm

    Args:
        graph: A dictionary representing the graph
        start: The starting node
        goal: The goal node

    Returns:
        A list of nodes visited in UCS order, or None
        if the goal is not found
    """

    # Create a priority queue to store the nodes to be visited
    queue = [(0, start, start)]

    # Create a dictionary to store the cost to reach each node
    costs = {start: 0}

    # Create a dictionary to store the path to each node
    paths = {start: [start]}

    # While the queue is not empty
    while queue:
        # Get the node with the lowest cost
        cost, node, path = heapq.heappop(queue)

        # If the node is the goal, return the path
        if node == goal:
            return path
        print(path)

        # For each neighbor of the node
        for neighbor in graph[node]:
            # Calculate the cost to reach the neighbor
            new_cost = costs[node] + graph[node][neighbor]

            # If the neighbor is not in the costs dictionary, or the new cost is less than the
            # cost stored in the dictionary
            if neighbor not in costs or new_cost < costs[neighbor]:
                # Update the cost to reach the neighbor
                costs[neighbor] = new_cost

                # Update the path to the neighbor
                paths[neighbor] = path + neighbor

                # Add the neighbor to the queue
                heapq.heappush(queue, (new_cost, neighbor, path + neighbor))

    # If the goal was not found, return None
    return None
# Function calling
graph = {
    "A": {"B": 1, "C": 4},
    "B": {"C": 2, "D": 1},
    "C": {"D": 2, "E": 3},
    "D": {"E": 1},
    "E": {}
}

print(ucs(graph, "A", "E"))
