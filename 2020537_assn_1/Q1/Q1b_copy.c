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
#include <pthread.h>

int marksA[6];
int marksB[6];
int numStudentsA;
int numStudentsB;

void* AverageA(){
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
    read(fp, &line, sz);
    //memset(line, 0, sizeof line);
    char *newLine;
    char *token2 = strtok_r(line, "\n",&newLine);
    token2 = strtok_r(NULL, "\n",&newLine);

    int a_cnt = 0, b_cnt = 0, a_marks = 0, b_marks = 0;
    //int marksA[6];
    for(int i=0;i<6;i++){
        marksA[i]=0;
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
                     marksA[assignment]+=atoi(token);
                     assignment++;
                     

                
            }
            local_marks += atoi(token);
        }

            token = strtok_r(NULL, ",",&sameLine);
            //memset(line, 0, sizeof line); 
       
    }

        if (set == 'A') {
            a_cnt++;
            numStudentsA++;
            a_marks += local_marks;
        } else if (set == 'B') {
            b_cnt++;
            numStudentsB++;
            b_marks += local_marks;
        }

        //printf("Student %s scored an average of %d marks in set %c\n", stu_id,local_marks / 6, set);
        token2 = strtok_r(NULL, "\n",&newLine);
        free(token);

        
    
}
    printf("**************Section A Average marks*******************\n");
    free(token2);
    for(int i=0; i<6; i++) {
        // char buff[1024];
        
        // sprintf(buff,"Assignment %d average marks in section A are %lf\n",i+1,((double)marksA[i])/a_cnt);
        // write(1,buff,strlen(buff));  
        //printf("Assignment %d average marks in section A are %lf\n",i+1,((double)marksA[i])/a_cnt);
        char buff1[1024];
        sprintf(buff1,"Assignment %d average marks in section A are %lf\n",i+1,((double)marksA[i])/a_cnt);
        write(1,buff1,strlen(buff1));


    }   
    // printf("\n\nAverage score in set A: %d\n", a_marks / a_cnt);
    // printf("Average score in set B: %d\n", b_marks / b_cnt);

    //free(line);
    close(fp);
    
    
}

void* AverageB(){
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
    read(fp, &line, sz);
    //memset(line, 0, sizeof line);
    char *newLine;
    char *token2 = strtok_r(line, "\n",&newLine);
    token2 = strtok_r(NULL, "\n",&newLine);

    int a_cnt = 0, b_cnt = 0, a_marks = 0, b_marks = 0;
    //int marksB[6];
    for(int i=0;i<6;i++){
        marksB[i]=0;
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
                     marksB[assignment]+=atoi(token);
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
    printf("\n");
    printf("**************Section B Average marks*******************\n");
    free(token2);
    for(int i=0; i<6; i++) {
        //printf("Assignment %d average marks in section B are %lf\n",i+1,((double)marksB[i])/b_cnt);
        char buff2[1024];
        sprintf(buff2,"Assignment %d average marks in section B are %lf\n",i+1,((double)marksB[i])/b_cnt);
        write(1,buff2,strlen(buff2));
    }   
    // printf("\n\nAverage score in set A: %d\n", a_marks / a_cnt);
    // printf("Average score in set B: %d\n", b_marks / b_cnt);

    //free(line);
    close(fp);

    
    }



int main(){
    pthread_t ret_value1, ret_value2;

    printf("The process id is %d\n", getpid());


    if(pthread_create(&ret_value1, NULL,&AverageA,NULL) != 0) {
        return 1;
    }
    if(pthread_join(ret_value1,NULL)!=0){
        return 3;
    }
    if(pthread_create(&ret_value2, NULL,&AverageB,NULL) != 0) {
        return 2;
    }
    // if(pthread_join(ret_value1,NULL)!=0){
    //     return 3;
    // }
    if(pthread_join(ret_value2,NULL) != 0){
        return 4;
    }
    printf("\n");
    printf("The average marks for all the assignments combined are\n");
    int numStudents=numStudentsB+numStudentsA;
    for(int i=0; i<6; i++) {
        //printf("Assignment %d average marks are %lf\n",i+1,((double)marksA[i]+(double)marksB[i])/numStudents);
        char buff3[1024];
        snprintf(buff3,1024,"Assignment %d average marks are %lf\n",i+1,((double)marksA[i]+(double)marksB[i])/numStudents);
        write(1,buff3,strlen(buff3));
    }
    

    
    return 0;
}

