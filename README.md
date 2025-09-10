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
3. Run the programme with "java SortingAlgorithms.java"

## Notes:
- The program runs warm-up benchmarks before actual timing to ensure the JVM has optimized execution paths.<br/>
- Results may vary depending on hardware and system load.<br/>
- Radix Sort is implemented for non-negative integers only.

## Example Output:


<img width="462" height="553" alt="Example_Benchmark" src="https://github.com/user-attachments/assets/fcf2b7c9-ec30-42a1-81b4-b88222a7ad36" />
<img width="477" height="282" alt="Example_Insertion" src="https://github.com/user-attachments/assets/a74e4cd2-e681-4d37-857a-3928352d86b2" />
<img width="475" height="571" alt="Example_merge" src="https://github.com/user-attachments/assets/7cc9afc3-496d-4682-82fc-1ef33edb7bc7" />
