# Huffman Coding for File Compression and Decompression
This project implements Huffman coding for file compression and decompression, utilizing concepts of priority queues, stacks, and binary trees. Huffman coding is a widely used algorithmic technique for data compression, commonly employed in formats like JPEG and MP3. This project provides both compression and decompression utilities based on Huffman coding, aiming to reduce file size efficiently.

# Overview
Huffman coding is an entropy encoding algorithm that compresses data by assigning shorter codes to more frequent characters and longer codes to less frequent characters.
This implementation includes:
 1- Compression Program: Compresses files by building a Huffman coding tree, generating a table of Huffman codes, and encoding the file based on these codes.
 2- Decompression Program: Decompresses files by reconstructing the Huffman coding tree from the encoded file and decoding the compressed bitstream.
iable-length codes based on character frequency, significantly reducing the number of bits needed for storage.

# Huffman Coding Process
## Building the Huffman Tree: 
1- Count the frequency of each character in the input file.

2- Build a priority queue of trees, each containing a single character and its frequency.

3- Iteratively merge the two trees with the smallest weights to create a new tree, until only one tree remains. This final tree is the Huffman coding tree.
## Encoding:
1- Traverse the Huffman tree to generate a variable-length binary code for each character.

2- Replace each character in the file with its corresponding Huffman code to create a compressed bitstream.
## Decoding:
1- Rebuild the Huffman tree from the encoded file's header information.

2- Traverse the Huffman tree according to the bitstream to decode and reconstruct the original file.
# Implementation Details
## Compression Program
- Build Huffman Tree: Analyze the input file to calculate character frequencies and build the Huffman tree.
- Generate Codes: Create a table of Huffman codes based on the tree structure.
- Write Compressed File: Encode the input file using the generated Huffman codes and write the compressed data to an output file. Include header information that describes the Huffman tree structure.
## Decompression Program
- Read Header Information: Extract the Huffman tree structure from the beginning of the compressed file.
- Rebuild Huffman Tree: Construct the Huffman tree from the header data.
- Decode Data: Read the compressed bitstream and decode it using the Huffman tree to reconstruct the original file.
# Usage
## Compression:
Run the compression program on the desired input file.

Example: java HuffmanCompress input.txt output.huff
## Decompression:

Run the decompression program on the compressed file.

Example: java HuffmanDecompress output.huff decompressed.txt
# ScreenShots For the Project
![image](https://github.com/user-attachments/assets/dd55fcd3-5eb6-4b83-9f19-221f8567d7f0)
## After Clicking on The Browser Button:
- Choosing the proper file the user want to compress:
![image](https://github.com/user-attachments/assets/09fc71d1-42e0-4f6e-8d97-881f0efc0524)
## After clicking on Compress Button :
- displaying the compressed file:
 ![image](https://github.com/user-attachments/assets/65b84e4d-a370-4b3e-8a59-13e990b468d5)
## Display the Huffman Table :
![image](https://github.com/user-attachments/assets/b81fa18d-3964-4492-8fcf-476bc8f67b84)
## Upon clicking the Decompress button, the file is restored to its original state, and the system displays any differences between the original and decompressed files to verify accuracy.


- 

