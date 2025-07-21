def compute(a, b, verbose=False):
    if verbose:
        print("Starting computation")
    if b < 0:
        b = -b
    return helper(a, b)

def helper(x, y):
    return x // y

print(compute(10, 5, verbose=True))
