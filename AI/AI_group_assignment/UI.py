import tkinter as tk
from tkinter import messagebox
from BidirectionalSearch import BidirectionalSearch
class Application(tk.Frame):
    def __init__(self, master=None):
        super().__init__(master)
        self.master = master
        self.pack()
        self.create_widgets()

    def create_widgets(self):
        self.hi_there = tk.Button(self)
        self.hi_there["text"] = "Create Graph"
        self.hi_there["command"] = self.create_graph
        self.hi_there.pack(side="top")

        self.quit = tk.Button(self, text="QUIT", fg="red",
                              command=self.master.destroy)
        self.quit.pack(side="bottom")

    def create_graph(self):
        # Number of Vertices in graph
        n = 15

        # Source Vertex
        src = 0

        # Destination Vertex
        dest = 14

        # Create a graph
        graph = BidirectionalSearch(n)
        graph.add_edge(0, 4)
        graph.add_edge(1, 4)
        graph.add_edge(2, 5)
        graph.add_edge(3, 5)
        graph.add_edge(4, 6)
        graph.add_edge(5, 6)
        graph.add_edge(6, 7)
        graph.add_edge(7, 8)
        graph.add_edge(8, 9)
        graph.add_edge(8, 10)
        graph.add_edge(9, 11)
        graph.add_edge(9, 12)
        graph.add_edge(10, 13)
        graph.add_edge(10, 14)

        out = graph.bidirectional_search(src, dest)

        if out == -1:
            messagebox.showinfo("Result", f"Path does not exist between {src} and {dest}")
        else:
            messagebox.showinfo("Result", f"Path exists between {src} and {dest}")

root = tk.Tk()
app = Application(master=root)
app.mainloop()