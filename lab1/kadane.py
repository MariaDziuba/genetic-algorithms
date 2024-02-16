from typing import List, Callable
import time
import tracemalloc
import random

random.seed(42)

def unopt_kadane(a: List):
    res = a[0]
    sum = 0
    min_sum = 0
    for r in range(len(a)):
        sum += a[r]
        res = max (res, sum - min_sum)
        min_sum = min (min_sum, sum)

def opt_kadane(a: List):
    res = a[0]
    sum = 0
    min_sum = 0
    for a_r in a:
        sum += a_r
        res = max (res, sum - min_sum)
        min_sum = min (min_sum, sum)

def performance_test(kadane_alg: Callable):
    print(kadane_alg)
    for arr_len in [100, 1_000, 10_000, 100_000, 1_000_000]:
        arr = [random.randint(1,1000) for _ in range(arr_len)]
        
        tracemalloc.start()
        start_time = time.time()
        res = kadane_alg(arr)

        elapsed_time = time.time() - start_time
        current, peak = tracemalloc.get_traced_memory()
        tracemalloc.stop()

        print(f"Array length: {arr_len}")
        print(f"Elapsed time: {elapsed_time:.4f} s")
        print(f"Current memory usage: {current / 10**6:.4f} MB, Peak was: {peak / 10**6:.4f} MB")

performance_test(kadane_alg=unopt_kadane)
# performance_test(kadane_alg=opt_kadane)