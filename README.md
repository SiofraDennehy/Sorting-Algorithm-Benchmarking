# Sorting Algorithm Benchmarking (Java)

This project implements and benchmarks multiple sorting algorithms in Java.  
It generates random arrays, sorts them using different algorithms, and records the **average runtime** (in milliseconds) across various input sizes.  

---

## Implemented Algorithms:
- **Bubble Sort** 
- **Insertion Sort**
- **Selection Sort**
- **Merge Sort** 
- **Radix Sort** 
---

## Features:
- **Performance benchmarking** of sorting algorithms.
- **Random array generation** (integers from 0–99).
- **JVM warm-up runs** to stabilize results.
- **Average runtime calculation** over multiple repetitions.
- **Clear console output** showing runtime comparisons.

---

## Requirements:
-Java 8+ installed on host

## How to Use:
1. Clone this repository
2. Compile the programme with "javac SortingAlgorithms.java"
3. Run the programme with "java SortingAlgorithms"

## Notes:
- The program runs warm-up benchmarks before actual timing to ensure the JVM has optimized execution paths.<br/>
- Results may vary depending on hardware and system load.<br/>
- Radix Sort is implemented for non-negative integers only.

## Example Output:

