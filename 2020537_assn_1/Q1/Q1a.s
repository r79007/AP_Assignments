	.file	"Q1a.c"
	.text
	.section	.rodata
.LC0:
	.string	"The process id is %d\n"
.LC1:
	.string	"Error occurred"
.LC2:
	.string	"fork"
	.align 8
.LC3:
	.string	"**************************In child process**********************"
.LC4:
	.string	"student_record.csv"
.LC5:
	.string	"open"
.LC6:
	.string	"read"
.LC7:
	.string	"\n"
.LC8:
	.string	","
	.align 8
.LC9:
	.string	"Assignment %d average marks in section A are %lf\n"
.LC10:
	.string	"write"
.LC11:
	.string	"waitpid"
	.align 8
.LC12:
	.string	"************************In parent process**********************"
.LC13:
	.string	"fopen"
	.align 8
.LC14:
	.string	"Assignment %d average marks in section B are %lf\n"
	.text
	.globl	main
	.type	main, @function
main:
.LFB6:
	.cfi_startproc
	endbr64
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	subq	$1368, %rsp
	.cfi_offset 15, -24
	.cfi_offset 14, -32
	.cfi_offset 13, -40
	.cfi_offset 12, -48
	.cfi_offset 3, -56
	movq	%fs:40, %rax
	movq	%rax, -56(%rbp)
	xorl	%eax, %eax
	call	getpid@PLT
	movl	%eax, %esi
	leaq	.LC0(%rip), %rdi
	movl	$0, %eax
	call	printf@PLT
	call	fork@PLT
	movl	%eax, -1296(%rbp)
	cmpl	$0, -1296(%rbp)
	jns	.L2
	leaq	.LC1(%rip), %rdi
	call	puts@PLT
	leaq	.LC2(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L2:
	cmpl	$0, -1296(%rbp)
	jne	.L3
	leaq	.LC3(%rip), %rdi
	call	puts@PLT
	movl	$10, %edi
	call	putchar@PLT
	movq	$1024, -1176(%rbp)
	movq	-1176(%rbp), %rax
	movq	%rax, %rdx
	subq	$1, %rdx
	movq	%rdx, -1168(%rbp)
	movq	%rax, -1392(%rbp)
	movq	$0, -1384(%rbp)
	movq	%rax, %r12
	movl	$0, %r13d
	movl	$16, %edx
	subq	$1, %rdx
	addq	%rdx, %rax
	movl	$16, %ebx
	movl	$0, %edx
	divq	%rbx
	imulq	$16, %rax, %rax
	movq	%rax, %rdx
	andq	$-4096, %rdx
	movq	%rsp, %rcx
	subq	%rdx, %rcx
	movq	%rcx, %rdx
.L4:
	cmpq	%rdx, %rsp
	je	.L5
	subq	$4096, %rsp
	orq	$0, 4088(%rsp)
	jmp	.L4
.L5:
	movq	%rax, %rdx
	andl	$4095, %edx
	subq	%rdx, %rsp
	movq	%rax, %rdx
	andl	$4095, %edx
	testq	%rdx, %rdx
	je	.L6
	andl	$4095, %eax
	subq	$8, %rax
	addq	%rsp, %rax
	orq	$0, (%rax)
.L6:
	movq	%rsp, %rax
	addq	$0, %rax
	movq	%rax, -1160(%rbp)
	movq	$0, -1152(%rbp)
	movl	$0, %esi
	leaq	.LC4(%rip), %rdi
	movl	$0, %eax
	call	open@PLT
	movl	%eax, -1284(%rbp)
	cmpl	$-1, -1284(%rbp)
	jne	.L7
	leaq	.LC5(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L7:
	movq	-1176(%rbp), %rdx
	movq	-1160(%rbp), %rcx
	movl	-1284(%rbp), %eax
	movq	%rcx, %rsi
	movl	%eax, %edi
	call	read@PLT
	movq	%rax, -1144(%rbp)
	cmpq	$-1, -1144(%rbp)
	jne	.L8
	leaq	.LC6(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L8:
	leaq	-1280(%rbp), %rdx
	movq	-1160(%rbp), %rax
	leaq	.LC7(%rip), %rsi
	movq	%rax, %rdi
	call	strtok_r@PLT
	movq	%rax, -1264(%rbp)
	leaq	-1280(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC7(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1264(%rbp)
	movl	$0, -1360(%rbp)
	movl	$0, -1364(%rbp)
	movl	$0, -1368(%rbp)
	movl	$0, -1356(%rbp)
	movl	$0, -1352(%rbp)
	jmp	.L9
.L10:
	movl	-1352(%rbp), %eax
	cltq
	movl	$0, -1120(%rbp,%rax,4)
	addl	$1, -1352(%rbp)
.L9:
	cmpl	$5, -1352(%rbp)
	jle	.L10
	jmp	.L11
.L21:
	movl	$2, -1348(%rbp)
	movl	$0, -1344(%rbp)
	movl	$0, -1340(%rbp)
	leaq	-1272(%rbp), %rdx
	movq	-1264(%rbp), %rax
	leaq	.LC8(%rip), %rsi
	movq	%rax, %rdi
	call	strtok_r@PLT
	movq	%rax, -1256(%rbp)
	jmp	.L12
.L18:
	cmpl	$0, -1348(%rbp)
	jle	.L13
	cmpl	$1, -1348(%rbp)
	je	.L14
	cmpl	$2, -1348(%rbp)
	jne	.L15
	movq	-1256(%rbp), %rax
	movq	%rax, -1128(%rbp)
	jmp	.L15
.L14:
	movq	-1256(%rbp), %rax
	movzbl	(%rax), %eax
	movb	%al, -1370(%rbp)
	nop
.L15:
	subl	$1, -1348(%rbp)
	jmp	.L16
.L13:
	cmpb	$65, -1370(%rbp)
	jne	.L17
	movl	-1340(%rbp), %eax
	cltq
	movl	-1120(%rbp,%rax,4), %ebx
	movq	-1256(%rbp), %rax
	movq	%rax, %rdi
	call	atoi@PLT
	leal	(%rbx,%rax), %edx
	movl	-1340(%rbp), %eax
	cltq
	movl	%edx, -1120(%rbp,%rax,4)
	addl	$1, -1340(%rbp)
.L17:
	movq	-1256(%rbp), %rax
	movq	%rax, %rdi
	call	atoi@PLT
	addl	%eax, -1344(%rbp)
.L16:
	leaq	-1272(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC8(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1256(%rbp)
.L12:
	cmpq	$0, -1256(%rbp)
	jne	.L18
	cmpb	$65, -1370(%rbp)
	jne	.L19
	addl	$1, -1360(%rbp)
	movl	-1344(%rbp), %eax
	addl	%eax, -1368(%rbp)
	jmp	.L20
.L19:
	cmpb	$66, -1370(%rbp)
	jne	.L20
	addl	$1, -1364(%rbp)
	movl	-1344(%rbp), %eax
	addl	%eax, -1356(%rbp)
.L20:
	leaq	-1280(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC7(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1264(%rbp)
	movq	-1256(%rbp), %rax
	movq	%rax, %rdi
	call	free@PLT
.L11:
	cmpq	$0, -1264(%rbp)
	jne	.L21
	movq	-1264(%rbp), %rax
	movq	%rax, %rdi
	call	free@PLT
	movl	$0, -1336(%rbp)
	jmp	.L22
.L24:
	movl	-1336(%rbp), %eax
	cltq
	movl	-1120(%rbp,%rax,4), %eax
	cvtsi2sdl	%eax, %xmm0
	cvtsi2sdl	-1360(%rbp), %xmm1
	divsd	%xmm1, %xmm0
	movl	-1336(%rbp), %eax
	leal	1(%rax), %edx
	leaq	-1088(%rbp), %rax
	leaq	.LC9(%rip), %rsi
	movq	%rax, %rdi
	movl	$1, %eax
	call	sprintf@PLT
	leaq	-1088(%rbp), %rax
	movq	%rax, %rdi
	call	strlen@PLT
	movq	%rax, %rdx
	leaq	-1088(%rbp), %rax
	movq	%rax, %rsi
	movl	$1, %edi
	call	write@PLT
	movq	%rax, -1136(%rbp)
	cmpq	$-1, -1136(%rbp)
	jne	.L23
	leaq	.LC10(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L23:
	addl	$1, -1336(%rbp)
.L22:
	cmpl	$5, -1336(%rbp)
	jle	.L24
	movl	-1284(%rbp), %eax
	movl	%eax, %edi
	call	close@PLT
	movl	$0, %edi
	call	exit@PLT
.L3:
	movq	%rsp, %rax
	movq	%rax, %r12
	movl	-1296(%rbp), %eax
	movl	$0, %edx
	movl	$0, %esi
	movl	%eax, %edi
	call	waitpid@PLT
	movl	%eax, -1292(%rbp)
	cmpl	$-1, -1292(%rbp)
	jne	.L25
	leaq	.LC11(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L25:
	leaq	.LC12(%rip), %rdi
	call	puts@PLT
	movl	$10, %edi
	call	putchar@PLT
	movq	$1024, -1232(%rbp)
	movq	-1232(%rbp), %rax
	movq	%rax, %rdx
	subq	$1, %rdx
	movq	%rdx, -1224(%rbp)
	movq	%rax, -1408(%rbp)
	movq	$0, -1400(%rbp)
	movq	%rax, %r14
	movl	$0, %r15d
	movl	$16, %edx
	subq	$1, %rdx
	addq	%rdx, %rax
	movl	$16, %ecx
	movl	$0, %edx
	divq	%rcx
	imulq	$16, %rax, %rax
	movq	%rax, %rdx
	andq	$-4096, %rdx
	movq	%rsp, %rbx
	subq	%rdx, %rbx
	movq	%rbx, %rdx
.L26:
	cmpq	%rdx, %rsp
	je	.L27
	subq	$4096, %rsp
	orq	$0, 4088(%rsp)
	jmp	.L26
.L27:
	movq	%rax, %rdx
	andl	$4095, %edx
	subq	%rdx, %rsp
	movq	%rax, %rdx
	andl	$4095, %edx
	testq	%rdx, %rdx
	je	.L28
	andl	$4095, %eax
	subq	$8, %rax
	addq	%rsp, %rax
	orq	$0, (%rax)
.L28:
	movq	%rsp, %rax
	addq	$0, %rax
	movq	%rax, -1216(%rbp)
	movq	$0, -1208(%rbp)
	movl	$0, %esi
	leaq	.LC4(%rip), %rdi
	movl	$0, %eax
	call	open@PLT
	movl	%eax, -1288(%rbp)
	cmpl	$-1, -1288(%rbp)
	jne	.L29
	leaq	.LC13(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L29:
	movq	-1232(%rbp), %rdx
	movq	-1216(%rbp), %rcx
	movl	-1288(%rbp), %eax
	movq	%rcx, %rsi
	movl	%eax, %edi
	call	read@PLT
	movq	%rax, -1200(%rbp)
	cmpq	$-1, -1200(%rbp)
	jne	.L30
	leaq	.LC6(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L30:
	leaq	-1280(%rbp), %rdx
	movq	-1216(%rbp), %rax
	leaq	.LC7(%rip), %rsi
	movq	%rax, %rdi
	call	strtok_r@PLT
	movq	%rax, -1248(%rbp)
	leaq	-1280(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC7(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1248(%rbp)
	movl	$0, -1332(%rbp)
	movl	$0, -1328(%rbp)
	movl	$0, -1324(%rbp)
	movl	$0, -1320(%rbp)
	movl	$0, -1316(%rbp)
	jmp	.L31
.L32:
	movl	-1316(%rbp), %eax
	cltq
	movl	$0, -1120(%rbp,%rax,4)
	addl	$1, -1316(%rbp)
.L31:
	cmpl	$5, -1316(%rbp)
	jle	.L32
	jmp	.L33
.L43:
	movl	$2, -1312(%rbp)
	movl	$0, -1308(%rbp)
	movl	$0, -1304(%rbp)
	leaq	-1272(%rbp), %rdx
	movq	-1248(%rbp), %rax
	leaq	.LC8(%rip), %rsi
	movq	%rax, %rdi
	call	strtok_r@PLT
	movq	%rax, -1240(%rbp)
	jmp	.L34
.L40:
	cmpl	$0, -1312(%rbp)
	jle	.L35
	cmpl	$1, -1312(%rbp)
	je	.L36
	cmpl	$2, -1312(%rbp)
	jne	.L37
	movq	-1240(%rbp), %rax
	movq	%rax, -1184(%rbp)
	jmp	.L37
.L36:
	movq	-1240(%rbp), %rax
	movzbl	(%rax), %eax
	movb	%al, -1369(%rbp)
	nop
.L37:
	subl	$1, -1312(%rbp)
	jmp	.L38
.L35:
	cmpb	$66, -1369(%rbp)
	jne	.L39
	movl	-1304(%rbp), %eax
	cltq
	movl	-1120(%rbp,%rax,4), %ebx
	movq	-1240(%rbp), %rax
	movq	%rax, %rdi
	call	atoi@PLT
	leal	(%rbx,%rax), %edx
	movl	-1304(%rbp), %eax
	cltq
	movl	%edx, -1120(%rbp,%rax,4)
	addl	$1, -1304(%rbp)
.L39:
	movq	-1240(%rbp), %rax
	movq	%rax, %rdi
	call	atoi@PLT
	addl	%eax, -1308(%rbp)
.L38:
	leaq	-1272(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC8(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1240(%rbp)
.L34:
	cmpq	$0, -1240(%rbp)
	jne	.L40
	cmpb	$65, -1369(%rbp)
	jne	.L41
	addl	$1, -1332(%rbp)
	movl	-1308(%rbp), %eax
	addl	%eax, -1324(%rbp)
	jmp	.L42
.L41:
	cmpb	$66, -1369(%rbp)
	jne	.L42
	addl	$1, -1328(%rbp)
	movl	-1308(%rbp), %eax
	addl	%eax, -1320(%rbp)
.L42:
	leaq	-1280(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC7(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1248(%rbp)
	movq	-1240(%rbp), %rax
	movq	%rax, %rdi
	call	free@PLT
.L33:
	cmpq	$0, -1248(%rbp)
	jne	.L43
	movq	-1248(%rbp), %rax
	movq	%rax, %rdi
	call	free@PLT
	movl	$0, -1300(%rbp)
	jmp	.L44
.L46:
	movl	-1300(%rbp), %eax
	cltq
	movl	-1120(%rbp,%rax,4), %eax
	cvtsi2sdl	%eax, %xmm0
	cvtsi2sdl	-1328(%rbp), %xmm1
	divsd	%xmm1, %xmm0
	movl	-1300(%rbp), %eax
	leal	1(%rax), %edx
	leaq	-1088(%rbp), %rax
	leaq	.LC14(%rip), %rsi
	movq	%rax, %rdi
	movl	$1, %eax
	call	sprintf@PLT
	leaq	-1088(%rbp), %rax
	movq	%rax, %rdi
	call	strlen@PLT
	movq	%rax, %rdx
	leaq	-1088(%rbp), %rax
	movq	%rax, %rsi
	movl	$1, %edi
	call	write@PLT
	movq	%rax, -1192(%rbp)
	cmpq	$-1, -1192(%rbp)
	jne	.L45
	leaq	.LC10(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L45:
	addl	$1, -1300(%rbp)
.L44:
	cmpl	$5, -1300(%rbp)
	jle	.L46
	movl	-1288(%rbp), %eax
	movl	%eax, %edi
	call	close@PLT
	movq	%r12, %rsp
	movl	$0, %eax
	movq	-56(%rbp), %rcx
	xorq	%fs:40, %rcx
	je	.L48
	call	__stack_chk_fail@PLT
.L48:
	leaq	-40(%rbp), %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE6:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 9.3.0-17ubuntu1~20.04) 9.3.0"
	.section	.note.GNU-stack,"",@progbits
	.section	.note.gnu.property,"a"
	.align 8
	.long	 1f - 0f
	.long	 4f - 1f
	.long	 5
0:
	.string	 "GNU"
1:
	.align 8
	.long	 0xc0000002
	.long	 3f - 2f
2:
	.long	 0x3
3:
	.align 8
4:
