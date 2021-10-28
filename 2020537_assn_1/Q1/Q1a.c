//
// Created by rohan on 15-Oct-21.
//

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/wait.h>



int main(){
    pid_t ret_value;

    printf("The process id is %d\n", getpid());

    ret_value=fork();

    if(ret_value<0){
        printf("Error occurred\n");
        perror("fork");
        exit(errno);

    }else if(ret_value==0){
        printf("**************************In child process**********************\n");
        //printf("The process id of child process is %d\n",getpid());
        printf("\n");
         //FILE *fp;
    
    size_t sz=1024;
    char line[sz];
    size_t len = 0;
    ssize_t nread;
    int fp;

    fp = open("student_record.csv", O_RDONLY);
    if (fp == -1) {
        perror("open");
        exit(errno);
    }

    // Get line 1 which is of no use
    //int nread;
    nread=read(fp, &line, sz);

    if(nread==-1){
        perror("read");
        exit(errno);
    }
    //memset(line, 0, sizeof line);
    char *newLine;
    char *token2 = strtok_r(line, "\n",&newLine);
    token2 = strtok_r(NULL, "\n",&newLine);

    int a_cnt = 0, b_cnt = 0, a_marks = 0, b_marks = 0;
    int marks[6];
    for(int i=0;i<6;i++){
        marks[i]=0;
    }

   
    while (token2) {
    
        int offset = 2;

        char *stu_id;
        char set;
        int local_marks = 0;
        int assignment=0;
        char *sameLine;
        char *token = strtok_r(token2, ",",&sameLine);

        while (token) {
            if (offset > 0) {
                switch (offset) {
                case 2:
                    stu_id = token;
                    break;
                case 1:
                    set = token[0];
                    break;
                }

                offset--;
            } else {
                if (set == 'A') {
                     marks[assignment]+=atoi(token);
                     assignment++;

                
            }
            local_marks += atoi(token);
        }

            token = strtok_r(NULL, ",",&sameLine);
            //memset(line, 0, sizeof line); 
       
    }

        if (set == 'A') {
            a_cnt++;
            a_marks += local_marks;
        } else if (set == 'B') {
            b_cnt++;
            b_marks += local_marks;
        }

        //printf("Student %s scored an average of %d marks in set %c\n", stu_id,local_marks / 6, set);
        token2 = strtok_r(NULL, "\n",&newLine);
        free(token);
    
}
    free(token2);
    ssize_t nwrite;
    for(int i=0; i<6; i++) {
        //printf("Assignment %d average marks in section A are %lf\n",i+1,((double)marks[i])/a_cnt);
        char buff[1024];
        sprintf(buff,"Assignment %d average marks in section A are %lf\n",i+1,((double)marks[i])/a_cnt);
        nwrite=write(1,buff,strlen(buff));
        if(nwrite==-1){
            perror("write");
            exit(errno);
        }
        //write(1,"Assignment %d average marks in section A are %lf\n",i+1,((double)marks[i])/a_cnt,100);
    }   
    
    // printf("\n\nAverage score in set A: %d\n", a_marks / a_cnt);
    // printf("Average score in set B: %d\n", b_marks / b_cnt);

    //free(line);
    close(fp);

    exit(0);
}
else{
        pid_t pid1=waitpid(ret_value,NULL,0);
        if(pid1==-1){
            perror("waitpid");
            exit(errno);
        }
        printf("************************In parent process**********************\n");
        //printf("The process id of parent process is %d\n",getpid());
        printf("\n");
        //FILE *fp;
    
    size_t sz=1024;
    char line[sz];
    size_t len = 0;
    ssize_t nread;
    int fp;
    fp = open("student_record.csv", O_RDONLY);
    if (fp == -1) {
        perror("fopen");
        exit(errno);
    }

    // Get line 1 which is of no use
    //int nread;
    nread=read(fp, &line, sz);

    if(nread==-1){
        perror("read");
        exit(errno);
    }
    //memset(line, 0, sizeof line);
    char *newLine;
    char *token2 = strtok_r(line, "\n",&newLine);
    token2 = strtok_r(NULL, "\n",&newLine);

    int a_cnt = 0, b_cnt = 0, a_marks = 0, b_marks = 0;
    int marks[6];
    for(int i=0;i<6;i++){
        marks[i]=0;
    }

   
    while (token2) {
        
        int offset = 2;

        char *stu_id;
        char set;
        int local_marks = 0;
        int assignment=0;

        char *sameLine;
        char *token = strtok_r(token2, ",",&sameLine);

        while (token) {
            if (offset > 0) {
                switch (offset) {
                case 2:
                    stu_id = token;
                    break;
                case 1:
                    set = token[0];
                    break;
                }

                offset--;
            } else {
                if (set == 'B') {
                     marks[assignment]+=atoi(token);
                     assignment++;

                
            }
            local_marks += atoi(token);
        }

            token = strtok_r(NULL, ",",&sameLine);
            //memset(line, 0, sizeof line);
       
    }

        if (set == 'A') {
            a_cnt++;
            a_marks += local_marks;
        } else if (set == 'B') {
            b_cnt++;
            b_marks += local_marks;
        }

        //printf("Student %s scored an average of %d marks in set %c\n", stu_id,local_marks / 6, set);
        token2 = strtok_r(NULL, "\n",&newLine);
        free(token);
    
}
    free(token2);
    
    for(int i=0; i<6; i++) {
        //printf("Assignment %d average marks in section B are %lf\n",i+1,((double)marks[i])/b_cnt);
        char buff[1024];
        
        sprintf(buff,"Assignment %d average marks in section B are %lf\n",i+1,((double)marks[i])/b_cnt);
        ssize_t nwrite;
        nwrite=write(1,buff,strlen(buff));
        if(nwrite==-1){
            perror("write");
            exit(errno);
        }  
    }
     
    // printf("\n\nAverage score in set A: %d\n", a_marks / a_cnt);
    // printf("Average score in set B: %d\n", b_marks / b_cnt);

    //free(line);
    close(fp);
    }
    return 0;
}

