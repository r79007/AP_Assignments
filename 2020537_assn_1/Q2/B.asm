extern C

section .data
		text2 db "You are in B", 10
		text3 db "The ascii characters are: "

section .bss
    	text resb 100

section .text
        global _B

_B:
		push rbp
		mov rbp, rsp
		
		push rdi
		call _printB     ;printing in B
		pop rdi

		push rdi
		call _printMess   ;printing message
		pop rdi

        mov rax, rdi  ;rax=input from A
        mov rbx, 256   ;to divide by 256
		;push rcx
		;mov rcx, 0   ;counter
		mov rcx, text
        call _iterate
		
		call _printLoop
		;pop rcx


		pop rbp
		;mov long[rbp+8], C
		push C
		ret
        ;mov rax, 60  ;exit syscall
        ;mov rdi, 0
        ;syscall

_printB:
		mov rax, 1
		mov rdi, 1
		mov rsi, text2
		mov rdx, 13
		syscall
		ret

_printMess:
		mov rax, 1
		mov rdi, 1
		mov rsi, text3
		mov rdx, 26
		syscall
		ret

_iterate:
		
        mov rdx, 0
        div rbx   ;dividing rax by 256
        ;push rdx  ;pushing rdx
		;inc rcx   ;increasing count   
        ;push rax   ;pushing rax(quotient) into the stack so that the write() system call doesn't change its value

		mov [rcx], rdx
		inc rcx
        ;call _printNum
                   
        ;pop rax           ;getting the value of rax back
		
        cmp rax, 0        ;if rax becomes 0 then we return otherwise we re run the loop
        jne _iterate
        ret

_printNum:
        ;mov rdx, [text]           ;write() syscall, printing rdx
        ;mov rcx, 50
        ;mov rdx, 255
		
		dec rcx
        push rcx
		
        mov rax, 1
        mov rdi, 1 
        mov rsi, rcx
        mov rdx, 1
        syscall

		pop rcx
		
		ret 
        ;jmp _iterate



_printLoop:
		   
		;pop rdx
		push rax
		call _printNum
		pop rax		
		
		cmp rcx, text
    	jge _printLoop
		ret
		 
