# _*_Makefile_*_
#target: dependencies
#	action

all: B link


B:	B.asm
	nasm -f elf64 B.asm -o B.o

link: A.c C.c B.o

	gcc -no-pie A.c B.o C.c -o Q2