"""
(2*3+4*(5-6))
"""

class InFixToPostFixConversion:
    """
    """
    def __init__(self):
        """
        """
        self.stack = []
        self.result= []
        self.precedence = {
            '(': 0,
            '+': 1,
            '-': 1,
            '*': 2,
            '/': 2,
            '^': 3
        }
    
    def push(self, c):
        self.stack.append(c)
    
    def pop(self):
        if not self.isEmpty():
            return self.stack.pop()
        else:
            return '$'
    
    def isEmpty(self):
        return self.stack == []
    
    def peek(self):
        if not self.isEmpty():
            return self.stack[-1]
        else:
            return '$'
    