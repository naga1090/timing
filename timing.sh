#!/usr/bin/env bash
PY=$(/opt/homebrew/bin/python3 timing.py)
JAV=$(java timing.java)
g++ -std=c++11 timing.cpp
CPP=$(./a.out)
numPY=4
numJAV=4
numCPP=2
numWordsPy=10000000
numWordsJav=100000
numWordsCpp=100000

totalPY=0
while IFS=':' read -ra arr; do
    for i in "${!arr[@]}"; do
        if [[ $i == 1 ]]; then
            totalPY=$(bc -l <<<"${totalPY}+${arr[$i]}")
        fi
    done
done <<<"$PY"
avgPY=$(bc -l <<<"${totalPY}/${numPY}")
avgPYperInt=$(bc -l <<<"${avgPY}/${numWordsPy}")

totalJAV1=0
totalJAV2=0
count=0
while IFS=':' read -ra arr; do
    for i in "${!arr[@]}"; do
        if [[ $i == 1 && $count < 4 ]]; then
            totalJAV1=$(bc -l <<<"${totalJAV1}+${arr[$i]}")
            count=$((count + 1))
        elif [[ $i == 1 && $count == 4 ]]; then
            totalJAV2=$(bc -l <<<"${totalJAV2}+${arr[$i]}")
        fi
    done
done <<<"$JAV"
avgJAV1=$(bc -l <<<"${totalJAV1}/${numJAV}")
avgJAV1perInt=$(bc -l <<<"${avgJAV1}/${numWordsJav}")
avgJAV2=$(bc -l <<<"${totalJAV2}/${numJAV}")
avgJAV2perInt=$(bc -l <<<"${avgJAV2}/${numWordsJav}")

totalCPP=0
while IFS=':' read -ra arr; do
    for i in "${!arr[@]}"; do
        if [[ $i == 1 ]]; then
            totalCPP=$(bc -l <<<"${totalCPP}+${arr[$i]}")
        fi
    done
done <<<"$CPP"
avgCPP=$(bc -l <<<"${totalCPP}/${numCPP}")
avgCPPperInt=$(bc -l <<<"${avgCPP}/${numWordsCpp}")

echo -e "Python average time: \t\t $avgPY"
echo -e "Python Average time per int: \t $avgPYperInt"
echo
echo -e "Java average time: \t\t $avgJAV1"
echo -e "Java average time per int: \t $avgJAV1perInt"
echo
echo -e "Java average time w/ SB: \t\t $avgJAV2"
echo -e "Java average time w/ SB per int: \t $avgJAV2perInt"
echo
echo -e "C++ average time: \t\t $avgCPP"
echo -e "C++ average time per int: \t $avgCPPperInt"
