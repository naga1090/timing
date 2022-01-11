#include <iostream>
#include <string>
#include <chrono>
#include <sstream>
using namespace std;
using namespace std::chrono;

string stringStream()
{
    string temp = "";
    for (int i = 0; i < 100000; i++)
    {
        string str;
        stringstream ss;
        ss << i;
        ss >> str;
        temp = temp + str;
    }
    return temp;
}

string toString()
{
    string temp = "";
    for (int i = 0; i < 100000; i++)
    {
        temp = temp + to_string(i);
    }
    return temp;  
}

int main()
{
    auto startTime_stringStream = high_resolution_clock::now();
    stringStream();
    auto endTime_stringStream = high_resolution_clock::now();

    auto startTime_toString = high_resolution_clock::now();
    toString();
    auto endTime_toString = high_resolution_clock::now();

    auto duration_stringStream = endTime_stringStream - startTime_stringStream;
    auto duration_toString = endTime_toString - startTime_toString;

    cout << "stringstream: " << duration_stringStream.count() / 1000000000. << endl;
    cout << "to string: " << duration_toString.count() / 1000000000. << endl;
    return 0;
}