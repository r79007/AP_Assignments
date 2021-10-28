extern C

section .data
        text dq 513
		text2 db "You are in B", 10
		text3 db "The ascii characters are: "

;section .bss
;        string resb 1

section .text
        global _printAscii

_printAscii:
		push rbp
		mov rbp, rsp
		
		push rdi
		call _printB
		pop rdi

		push rdi
		call _printMess
		pop rdi

        mov rax, rdi  ;rax=input from A
        mov rbx, 256   ;to divide by 256
        call _iterate

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
               
        push rax   ;pushing rax(quotient) into the stack so that the write() system call doesn't change its value
                
        call _printNum
                   
        pop rax           ;getting the value of rax back
        cmp rax, 0        ;if rax becomes 0 then we return otherwise we re run the loop
        jne _iterate
        ret

_printNum:
        ;mov rdx, [string]           ;write() syscall, printing rdx
        ;mov rcx, 50
        ;mov rdx, 255
		
        mov [text], rdx   ;moving in the value of the remainder into text.
        mov rax, 1
        mov rdi, 1 
        mov rsi, text
        mov rdx, 1
        syscall
		ret 
        ;jmp _iterate
        
