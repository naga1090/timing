import timeit


def str_function():
    temp = ""
    for i in range(10000000):
        temp += str(i)
    return temp


def s_keyword():
    temp = ""
    for i in range(10000000):
        temp += "% s" % i
    return temp


def s_format():
    temp = ""
    for i in range(10000000):
        temp += "{}".format(i)
    return temp


def f_string():
    temp = ""
    for i in range(10000000):
        temp += f'{i}'
    return temp


def main():
    print("str function: ", timeit.timeit(str_function, number=1))
    print("s keyword: ", timeit.timeit(s_keyword, number=1))
    print("s format: ", timeit.timeit(s_format, number=1))
    print("f string: ", timeit.timeit(f_string, number=1))


if __name__ == '__main__':
    main()
