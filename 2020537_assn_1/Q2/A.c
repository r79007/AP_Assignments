#include<stdio.h>
#include<stdlib.h>
#include<stdint.h>

void A(){
    //int64_t num=9223372036854775807;
    //int64_t num=97*256;
    //0110000101111010
    //0111001001101111011010000110000101101110
    //int64_t num=24954;
    int64_t num=491495383406LL;
    //int64_t num=478560413000;
    //int64_t num=24954;
    printf("You are in A\n");
    extern void _B(int64_t);
    //printf("The ascii characters are: \n");
    _B(num);
    
    
}

int main(){
    A();

    return 0;

}