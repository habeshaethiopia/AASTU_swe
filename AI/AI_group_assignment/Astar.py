from queue import PriorityQueue

class Graph:
    def __init__(self):
        self.graph = {}

    def add_edge(self, u, v, w):
        if u not in self.graph:
            self.graph[u] = {}
        self.graph[u][v] = w

    def a_star_search(self, start, end):
        visited = set()
        pq = PriorityQueue()
        pq.put((0, start))
        while not pq.empty():
            cost, node = pq.get()
            if node == end:
                return cost
            visited.add(node)
            for neighbor, weight in self.graph[node].items():
                if neighbor not in visited:
                    pq.put((weight + cost, neighbor))
        return None

g = Graph()
g.add_edge('A', 'B', 5)
g.add_edge('A', 'C', 10)
g.add_edge('B', 'D', 8)
g.add_edge('C', 'D', 12)
g.add_edge('D', 'E', 6)

start = 'A'
end = 'E'
print(f"The shortest path between {start} and {end} is: {g.a_star_search(start, end)}")
