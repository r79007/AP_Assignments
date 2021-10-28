# _*_Makefile_*_
#target: dependencies
#	action

all: assemble compile link

assemble: Q1a.c Q1b.c
		gcc -S -o Q1a.s Q1a.c
		gcc -S -o Q1b.s Q1b.c

compile: Q1a.s Q1b.s
		gcc -o Q1a.o -c Q1a.s
		gcc -o Q1b.o -c Q1b.s

link: Q1a.o Q1b.o

		gcc -o Q1a Q1a.o
		gcc -pthread Q1b.o -o Q1b

assemble_Q1a: Q1a.c 
		gcc -S -o Q1a.s Q1a.c

compile_Q1a: Q1a.s 
		gcc -o Q1a.o -c Q1a.s

link_Q1a: Q1a.o 

		gcc -o Q1a Q1a.o

assemble_Q1b: Q1b.c 
		gcc -S -o Q1b.s Q1b.c

compile_Q1b: Q1b.s 
		gcc -o Q1b.o -c Q1b.s

link_Q1b: Q1b.o 

		gcc -pthread Q1b.o -o Q1b

