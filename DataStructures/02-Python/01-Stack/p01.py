#Symbol Balancing
import Stack

def checkSymbolBalance(input):
    symbol_stack = Stack()
    balanced = 0
    for symbols in input:
        if symbols in ["(","{","["]:
            symbol_stack.push(symbols)
        else:
            if symbol_stack.isEmpty():
                balanced = 0
            else:
                top_symbol = symbol_stack.pop()
        if not def matches(top_symbol,symbols):
            balanced = 0
        else:
            balanced = 1
    return balanced

if __name__ == "__main__":
    print(checkSymbolBalance("([)]"))
    print(checkSymbolBalance("[(()]"))
