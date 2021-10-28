	.file	"Q1b.c"
	.text
	.comm	marksA,24,16
	.comm	marksB,24,16
	.comm	numStudentsA,4,4
	.comm	numStudentsB,4,4
	.section	.rodata
.LC0:
	.string	"student_record.csv"
.LC1:
	.string	"open"
.LC2:
	.string	"read"
.LC3:
	.string	"\n"
.LC4:
	.string	","
	.align 8
.LC5:
	.string	"**************Section A Average marks*******************"
	.align 8
.LC6:
	.string	"Assignment %d average marks in section A are %lf\n"
.LC7:
	.string	"write"
	.text
	.globl	AverageA
	.type	AverageA, @function
AverageA:
.LFB6:
	.cfi_startproc
	endbr64
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	pushq	%r12
	pushq	%rbx
	subq	$1184, %rsp
	.cfi_offset 12, -24
	.cfi_offset 3, -32
	movq	%fs:40, %rax
	movq	%rax, -24(%rbp)
	xorl	%eax, %eax
	movq	%rsp, %rax
	movq	%rax, %r12
	movq	$1024, -1112(%rbp)
	movq	-1112(%rbp), %rax
	movq	%rax, %rdx
	subq	$1, %rdx
	movq	%rdx, -1104(%rbp)
	movq	%rax, %rsi
	movl	$0, %edi
	movq	%rax, %rcx
	movl	$0, %ebx
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
.L2:
	cmpq	%rdx, %rsp
	je	.L3
	subq	$4096, %rsp
	orq	$0, 4088(%rsp)
	jmp	.L2
.L3:
	movq	%rax, %rdx
	andl	$4095, %edx
	subq	%rdx, %rsp
	movq	%rax, %rdx
	andl	$4095, %edx
	testq	%rdx, %rdx
	je	.L4
	andl	$4095, %eax
	subq	$8, %rax
	addq	%rsp, %rax
	orq	$0, (%rax)
.L4:
	movq	%rsp, %rax
	addq	$0, %rax
	movq	%rax, -1096(%rbp)
	movq	$0, -1088(%rbp)
	movl	$0, %esi
	leaq	.LC0(%rip), %rdi
	movl	$0, %eax
	call	open@PLT
	movl	%eax, -1148(%rbp)
	cmpl	$-1, -1148(%rbp)
	jne	.L5
	leaq	.LC1(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L5:
	movq	-1112(%rbp), %rdx
	movq	-1096(%rbp), %rcx
	movl	-1148(%rbp), %eax
	movq	%rcx, %rsi
	movl	%eax, %edi
	call	read@PLT
	movq	%rax, -1080(%rbp)
	cmpq	$-1, -1080(%rbp)
	jne	.L6
	leaq	.LC2(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L6:
	leaq	-1144(%rbp), %rdx
	movq	-1096(%rbp), %rax
	leaq	.LC3(%rip), %rsi
	movq	%rax, %rdi
	call	strtok_r@PLT
	movq	%rax, -1128(%rbp)
	leaq	-1144(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC3(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1128(%rbp)
	movl	$0, -1184(%rbp)
	movl	$0, -1180(%rbp)
	movl	$0, -1176(%rbp)
	movl	$0, -1172(%rbp)
	movl	$0, -1168(%rbp)
	jmp	.L7
.L8:
	movl	-1168(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksA(%rip), %rax
	movl	$0, (%rdx,%rax)
	addl	$1, -1168(%rbp)
.L7:
	cmpl	$5, -1168(%rbp)
	jle	.L8
	jmp	.L9
.L19:
	movl	$2, -1164(%rbp)
	movl	$0, -1160(%rbp)
	movl	$0, -1156(%rbp)
	leaq	-1136(%rbp), %rdx
	movq	-1128(%rbp), %rax
	leaq	.LC4(%rip), %rsi
	movq	%rax, %rdi
	call	strtok_r@PLT
	movq	%rax, -1120(%rbp)
	jmp	.L10
.L16:
	cmpl	$0, -1164(%rbp)
	jle	.L11
	cmpl	$1, -1164(%rbp)
	je	.L12
	cmpl	$2, -1164(%rbp)
	jne	.L13
	movq	-1120(%rbp), %rax
	movq	%rax, -1064(%rbp)
	jmp	.L13
.L12:
	movq	-1120(%rbp), %rax
	movzbl	(%rax), %eax
	movb	%al, -1185(%rbp)
	nop
.L13:
	subl	$1, -1164(%rbp)
	jmp	.L14
.L11:
	cmpb	$65, -1185(%rbp)
	jne	.L15
	movl	-1156(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksA(%rip), %rax
	movl	(%rdx,%rax), %ebx
	movq	-1120(%rbp), %rax
	movq	%rax, %rdi
	call	atoi@PLT
	leal	(%rbx,%rax), %ecx
	movl	-1156(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksA(%rip), %rax
	movl	%ecx, (%rdx,%rax)
	addl	$1, -1156(%rbp)
.L15:
	movq	-1120(%rbp), %rax
	movq	%rax, %rdi
	call	atoi@PLT
	addl	%eax, -1160(%rbp)
.L14:
	leaq	-1136(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC4(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1120(%rbp)
.L10:
	cmpq	$0, -1120(%rbp)
	jne	.L16
	cmpb	$65, -1185(%rbp)
	jne	.L17
	addl	$1, -1184(%rbp)
	movl	numStudentsA(%rip), %eax
	addl	$1, %eax
	movl	%eax, numStudentsA(%rip)
	movl	-1160(%rbp), %eax
	addl	%eax, -1176(%rbp)
	jmp	.L18
.L17:
	cmpb	$66, -1185(%rbp)
	jne	.L18
	addl	$1, -1180(%rbp)
	movl	numStudentsB(%rip), %eax
	addl	$1, %eax
	movl	%eax, numStudentsB(%rip)
	movl	-1160(%rbp), %eax
	addl	%eax, -1172(%rbp)
.L18:
	leaq	-1144(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC3(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1128(%rbp)
	movq	-1120(%rbp), %rax
	movq	%rax, %rdi
	call	free@PLT
.L9:
	cmpq	$0, -1128(%rbp)
	jne	.L19
	leaq	.LC5(%rip), %rdi
	call	puts@PLT
	movq	-1128(%rbp), %rax
	movq	%rax, %rdi
	call	free@PLT
	movl	$0, -1152(%rbp)
	jmp	.L20
.L22:
	movl	-1152(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksA(%rip), %rax
	movl	(%rdx,%rax), %eax
	cvtsi2sdl	%eax, %xmm0
	cvtsi2sdl	-1184(%rbp), %xmm1
	divsd	%xmm1, %xmm0
	movl	-1152(%rbp), %eax
	leal	1(%rax), %edx
	leaq	-1056(%rbp), %rax
	leaq	.LC6(%rip), %rsi
	movq	%rax, %rdi
	movl	$1, %eax
	call	sprintf@PLT
	leaq	-1056(%rbp), %rax
	movq	%rax, %rdi
	call	strlen@PLT
	movq	%rax, %rdx
	leaq	-1056(%rbp), %rax
	movq	%rax, %rsi
	movl	$1, %edi
	call	write@PLT
	movq	%rax, -1072(%rbp)
	cmpq	$-1, -1072(%rbp)
	jne	.L21
	leaq	.LC7(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L21:
	addl	$1, -1152(%rbp)
.L20:
	cmpl	$5, -1152(%rbp)
	jle	.L22
	movl	-1148(%rbp), %eax
	movl	%eax, %edi
	call	close@PLT
	movq	%r12, %rsp
	nop
	movq	-24(%rbp), %rbx
	xorq	%fs:40, %rbx
	je	.L23
	call	__stack_chk_fail@PLT
.L23:
	leaq	-16(%rbp), %rsp
	popq	%rbx
	popq	%r12
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE6:
	.size	AverageA, .-AverageA
	.section	.rodata
	.align 8
.LC8:
	.string	"**************Section B Average marks*******************"
	.align 8
.LC9:
	.string	"Assignment %d average marks in section B are %lf\n"
	.text
	.globl	AverageB
	.type	AverageB, @function
AverageB:
.LFB7:
	.cfi_startproc
	endbr64
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	pushq	%r12
	pushq	%rbx
	subq	$1184, %rsp
	.cfi_offset 12, -24
	.cfi_offset 3, -32
	movq	%fs:40, %rax
	movq	%rax, -24(%rbp)
	xorl	%eax, %eax
	movq	%rsp, %rax
	movq	%rax, %r12
	movq	$1024, -1112(%rbp)
	movq	-1112(%rbp), %rax
	movq	%rax, %rdx
	subq	$1, %rdx
	movq	%rdx, -1104(%rbp)
	movq	%rax, %rsi
	movl	$0, %edi
	movq	%rax, %rcx
	movl	$0, %ebx
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
.L25:
	cmpq	%rdx, %rsp
	je	.L26
	subq	$4096, %rsp
	orq	$0, 4088(%rsp)
	jmp	.L25
.L26:
	movq	%rax, %rdx
	andl	$4095, %edx
	subq	%rdx, %rsp
	movq	%rax, %rdx
	andl	$4095, %edx
	testq	%rdx, %rdx
	je	.L27
	andl	$4095, %eax
	subq	$8, %rax
	addq	%rsp, %rax
	orq	$0, (%rax)
.L27:
	movq	%rsp, %rax
	addq	$0, %rax
	movq	%rax, -1096(%rbp)
	movq	$0, -1088(%rbp)
	movl	$0, %esi
	leaq	.LC0(%rip), %rdi
	movl	$0, %eax
	call	open@PLT
	movl	%eax, -1148(%rbp)
	cmpl	$-1, -1148(%rbp)
	jne	.L28
	leaq	.LC1(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L28:
	movq	-1112(%rbp), %rdx
	movq	-1096(%rbp), %rcx
	movl	-1148(%rbp), %eax
	movq	%rcx, %rsi
	movl	%eax, %edi
	call	read@PLT
	movq	%rax, -1080(%rbp)
	cmpq	$-1, -1080(%rbp)
	jne	.L29
	leaq	.LC2(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L29:
	leaq	-1144(%rbp), %rdx
	movq	-1096(%rbp), %rax
	leaq	.LC3(%rip), %rsi
	movq	%rax, %rdi
	call	strtok_r@PLT
	movq	%rax, -1128(%rbp)
	leaq	-1144(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC3(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1128(%rbp)
	movl	$0, -1184(%rbp)
	movl	$0, -1180(%rbp)
	movl	$0, -1176(%rbp)
	movl	$0, -1172(%rbp)
	movl	$0, -1168(%rbp)
	jmp	.L30
.L31:
	movl	-1168(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksB(%rip), %rax
	movl	$0, (%rdx,%rax)
	addl	$1, -1168(%rbp)
.L30:
	cmpl	$5, -1168(%rbp)
	jle	.L31
	jmp	.L32
.L42:
	movl	$2, -1164(%rbp)
	movl	$0, -1160(%rbp)
	movl	$0, -1156(%rbp)
	leaq	-1136(%rbp), %rdx
	movq	-1128(%rbp), %rax
	leaq	.LC4(%rip), %rsi
	movq	%rax, %rdi
	call	strtok_r@PLT
	movq	%rax, -1120(%rbp)
	jmp	.L33
.L39:
	cmpl	$0, -1164(%rbp)
	jle	.L34
	cmpl	$1, -1164(%rbp)
	je	.L35
	cmpl	$2, -1164(%rbp)
	jne	.L36
	movq	-1120(%rbp), %rax
	movq	%rax, -1064(%rbp)
	jmp	.L36
.L35:
	movq	-1120(%rbp), %rax
	movzbl	(%rax), %eax
	movb	%al, -1185(%rbp)
	nop
.L36:
	subl	$1, -1164(%rbp)
	jmp	.L37
.L34:
	cmpb	$66, -1185(%rbp)
	jne	.L38
	movl	-1156(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksB(%rip), %rax
	movl	(%rdx,%rax), %ebx
	movq	-1120(%rbp), %rax
	movq	%rax, %rdi
	call	atoi@PLT
	leal	(%rbx,%rax), %ecx
	movl	-1156(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksB(%rip), %rax
	movl	%ecx, (%rdx,%rax)
	addl	$1, -1156(%rbp)
.L38:
	movq	-1120(%rbp), %rax
	movq	%rax, %rdi
	call	atoi@PLT
	addl	%eax, -1160(%rbp)
.L37:
	leaq	-1136(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC4(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1120(%rbp)
.L33:
	cmpq	$0, -1120(%rbp)
	jne	.L39
	cmpb	$65, -1185(%rbp)
	jne	.L40
	addl	$1, -1184(%rbp)
	movl	-1160(%rbp), %eax
	addl	%eax, -1176(%rbp)
	jmp	.L41
.L40:
	cmpb	$66, -1185(%rbp)
	jne	.L41
	addl	$1, -1180(%rbp)
	movl	-1160(%rbp), %eax
	addl	%eax, -1172(%rbp)
.L41:
	leaq	-1144(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC3(%rip), %rsi
	movl	$0, %edi
	call	strtok_r@PLT
	movq	%rax, -1128(%rbp)
	movq	-1120(%rbp), %rax
	movq	%rax, %rdi
	call	free@PLT
.L32:
	cmpq	$0, -1128(%rbp)
	jne	.L42
	movl	$10, %edi
	call	putchar@PLT
	leaq	.LC8(%rip), %rdi
	call	puts@PLT
	movq	-1128(%rbp), %rax
	movq	%rax, %rdi
	call	free@PLT
	movl	$0, -1152(%rbp)
	jmp	.L43
.L45:
	movl	-1152(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksB(%rip), %rax
	movl	(%rdx,%rax), %eax
	cvtsi2sdl	%eax, %xmm0
	cvtsi2sdl	-1180(%rbp), %xmm1
	divsd	%xmm1, %xmm0
	movl	-1152(%rbp), %eax
	leal	1(%rax), %edx
	leaq	-1056(%rbp), %rax
	leaq	.LC9(%rip), %rsi
	movq	%rax, %rdi
	movl	$1, %eax
	call	sprintf@PLT
	leaq	-1056(%rbp), %rax
	movq	%rax, %rdi
	call	strlen@PLT
	movq	%rax, %rdx
	leaq	-1056(%rbp), %rax
	movq	%rax, %rsi
	movl	$1, %edi
	call	write@PLT
	movq	%rax, -1072(%rbp)
	cmpq	$-1, -1072(%rbp)
	jne	.L44
	leaq	.LC7(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L44:
	addl	$1, -1152(%rbp)
.L43:
	cmpl	$5, -1152(%rbp)
	jle	.L45
	movl	-1148(%rbp), %eax
	movl	%eax, %edi
	call	close@PLT
	movq	%r12, %rsp
	nop
	movq	-24(%rbp), %rbx
	xorq	%fs:40, %rbx
	je	.L46
	call	__stack_chk_fail@PLT
.L46:
	leaq	-16(%rbp), %rsp
	popq	%rbx
	popq	%r12
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE7:
	.size	AverageB, .-AverageB
	.section	.rodata
.LC10:
	.string	"The process id is %d\n"
.LC11:
	.string	"pthread_create"
.LC12:
	.string	"pthread_join"
	.align 8
.LC13:
	.string	"The average marks for all the assignments combined are"
	.align 8
.LC14:
	.string	"Assignment %d average marks are %lf\n"
	.text
	.globl	main
	.type	main, @function
main:
.LFB8:
	.cfi_startproc
	endbr64
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$1072, %rsp
	movq	%fs:40, %rax
	movq	%rax, -8(%rbp)
	xorl	%eax, %eax
	call	getpid@PLT
	movl	%eax, %esi
	leaq	.LC10(%rip), %rdi
	movl	$0, %eax
	call	printf@PLT
	leaq	-1064(%rbp), %rax
	movl	$0, %ecx
	leaq	AverageA(%rip), %rdx
	movl	$0, %esi
	movq	%rax, %rdi
	call	pthread_create@PLT
	testl	%eax, %eax
	je	.L48
	leaq	.LC11(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L48:
	movq	-1064(%rbp), %rax
	movl	$0, %esi
	movq	%rax, %rdi
	call	pthread_join@PLT
	testl	%eax, %eax
	je	.L49
	leaq	.LC12(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L49:
	leaq	-1056(%rbp), %rax
	movl	$0, %ecx
	leaq	AverageB(%rip), %rdx
	movl	$0, %esi
	movq	%rax, %rdi
	call	pthread_create@PLT
	testl	%eax, %eax
	je	.L50
	leaq	.LC11(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L50:
	movq	-1056(%rbp), %rax
	movl	$0, %esi
	movq	%rax, %rdi
	call	pthread_join@PLT
	testl	%eax, %eax
	je	.L51
	leaq	.LC12(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L51:
	movl	$10, %edi
	call	putchar@PLT
	leaq	.LC13(%rip), %rdi
	call	puts@PLT
	movl	numStudentsB(%rip), %edx
	movl	numStudentsA(%rip), %eax
	addl	%edx, %eax
	movl	%eax, -1068(%rbp)
	movl	$0, -1072(%rbp)
	jmp	.L52
.L54:
	movl	-1072(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksA(%rip), %rax
	movl	(%rdx,%rax), %eax
	cvtsi2sdl	%eax, %xmm1
	movl	-1072(%rbp), %eax
	cltq
	leaq	0(,%rax,4), %rdx
	leaq	marksB(%rip), %rax
	movl	(%rdx,%rax), %eax
	cvtsi2sdl	%eax, %xmm0
	addsd	%xmm1, %xmm0
	cvtsi2sdl	-1068(%rbp), %xmm1
	divsd	%xmm1, %xmm0
	movl	-1072(%rbp), %eax
	leal	1(%rax), %edx
	leaq	-1040(%rbp), %rax
	movl	%edx, %ecx
	leaq	.LC14(%rip), %rdx
	movl	$1024, %esi
	movq	%rax, %rdi
	movl	$1, %eax
	call	snprintf@PLT
	leaq	-1040(%rbp), %rax
	movq	%rax, %rdi
	call	strlen@PLT
	movq	%rax, %rdx
	leaq	-1040(%rbp), %rax
	movq	%rax, %rsi
	movl	$1, %edi
	call	write@PLT
	movq	%rax, -1048(%rbp)
	cmpq	$-1, -1048(%rbp)
	jne	.L53
	leaq	.LC7(%rip), %rdi
	call	perror@PLT
	call	__errno_location@PLT
	movl	(%rax), %eax
	movl	%eax, %edi
	call	exit@PLT
.L53:
	addl	$1, -1072(%rbp)
.L52:
	cmpl	$5, -1072(%rbp)
	jle	.L54
	movl	$0, %eax
	movq	-8(%rbp), %rcx
	xorq	%fs:40, %rcx
	je	.L56
	call	__stack_chk_fail@PLT
.L56:
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE8:
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
