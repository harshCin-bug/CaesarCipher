# 🔐 Cryptographic Cipher Tool: Symmetric Substitution (Caesar)

## Project Author & Affiliation
* **Author:** Harsh Chakravarti

---

## Executive Summary
This repository contains a Java-based implementation of a classical symmetric-key algorithm. The program provides a command-line interface for users to encrypt and decrypt string data by applying a mathematical shift to alphabetic characters, demonstrating the foundational mechanics of data obfuscation.

## Algorithmic Logic (Java Implementation)
Instead of relying on hardcoded alphabet arrays or mapping tables, this program utilizes dynamic ASCII value manipulation for optimal memory efficiency.

* **Character Extraction:** Iterates through the input string using `toCharArray()`.
* **Case Handling & Bounds:** Dynamically checks if a character is uppercase (ASCII 65-90) or lowercase (ASCII 97-122) before applying logic.
* **Modular Arithmetic:** Applies a transformation formula to ensure characters wrap around the alphabet boundary seamlessly without breaking the ASCII range: 
  `char newChar = (char) (((((int) oldChar + shift) % baseASCII) % 26) + baseASCII)`
* **Data Sanitization:** Non-alphabetic characters (spaces, numbers, punctuation) bypass the shift logic entirely to maintain the underlying structural integrity of the message.

## Verified Test Cases & Execution Examples

The implementation has been programmatically verified using standard cryptographic test boundaries. Below is the functional walkthrough of the system's runtime execution.

### Case 1: Data Obfuscation (Encryption Flow)
* **Input Plaintext String:** `Crypto-2026!`
* **Configured Shift Key ($k$):** `5`
* **Mathematical Walkthrough:**
  * Alpha-character transformations follow standard mod-26 arithmetic:
    * `C` (ASCII 67) $\rightarrow$ shifted by 5 $\rightarrow$ `H` (ASCII 72)
    * `y` (ASCII 121) $\rightarrow$ shifted by 5 $\rightarrow$ loops through boundary $\rightarrow$ `d` (ASCII 100)
  * Boundary sanitization checks run perfectly: The hyphen `-`, integers `2026`, and exclamation mark `!` skip evaluation blocks to preserve structural formatting.
* **Programmatic Ciphertext Output:** `Hwdpyt-2026!`

### Case 2: Data Recovery (Decryption Flow)
* **Input Ciphertext String:** `Hwdpyt-2026!`
* **Configured Shift Key ($k$):** `5`
* **Mathematical Walkthrough:**
  * The tool applies inverse directional shifts using the original key constraint ($\text{Shift} = 26 - k$).
    * `H` (ASCII 72) $\rightarrow$ shifted back by 5 $\rightarrow$ `C` (ASCII 67)
    * `d` (ASCII 100) $\rightarrow$ shifted back by 5 $\rightarrow$ loops reverse boundary $\rightarrow$ `y` (ASCII 121)
* **Programmatic Plaintext Recovery:** `Crypto-2026!`

## Security Context & Vulnerability Assessment
*Note: This project was built to demonstrate core algorithmic programming and symmetric key concepts. It is not intended for secure data transmission.*

From a modern cybersecurity perspective, this algorithm is fundamentally insecure due to two primary vulnerabilities:
1. **Insufficient Keyspace:** With an alphabet of 26 letters, there are only 25 possible functional keys. This makes the ciphertext trivial to break using an automated brute-force attack.
2. **Lack of Diffusion:** The algorithm is highly susceptible to Statistical Frequency Analysis. Because each letter is mapped one-to-one, the frequency distribution of characters in the encrypted output perfectly mirrors the distribution of the plaintext language.
