import calendar
import os
import glob

def convert(date):
    date= date.strip()
    if("january" in date):
        date = date.strip('january,')
        result = [1]
        result.append(int(date.strip()))
        return result
    elif("febuary" in date):
        date = date.strip('febuary,')
        result = [2]
        result.append(int(date.strip()))
        return result
    elif("march" in date):
        date = date.strip('march,')
        result = [3]
        result.append(int(date.strip()))
        return result
    elif("april" in date):
        date = date.strip('april,')
        result = [4]
        result.append(int(date.strip())) 
        return result
    elif("may" in date):
        date = date.strip('may,')
        result = [5]
        result.append(int(date.strip())) 
        return result
    elif("june" in date):
        date = date.strip('june,')
        result = [6]
        result.append(int(date.strip())) 
        return result
    elif("july" in date):
        date = date.strip('july,')
        result = [7]
        result.append(int(date.strip()))
        return result
    elif("august" in date):
        date = date.strip('august,')
        result = [8]
        result.append(int(date.strip()))
        return result
    elif("september" in date):
        date = date.strip('september,')
        result = [9] 
        result.append(int(date.strip())) 
        return result
    elif("october" in date):
        date = date.strip('october,')
        result = [10]
        result.append(int(date.strip())) 
        return result
    elif("november" in date):
        date = date.strip('november,')
        result = [11]
        result.append(int(date.strip())) 
        return result
    elif("december" in date): 
        date = date.strip('december,')
        result = [12]
        result.append(int(date.strip())) 
        return result
    else:
        return [go, fish]

dname = raw_input('Enter path: ')
files = [f for f in glob.glob(dname +"**/*.txt")]
monthList = []
yearList = []
for f in files:
    fileObject = open(f, 'r')
    for line in fileObject:
        if("release date:" in line.lower()):
            line = line.strip('release date:')
            temp =convert(line.lower())
            monthList.append(temp[0])
            yearList.append(temp[1])
averageMonth = sum(monthList) / len(monthList)
averageYear = sum(yearList) / len(yearList)
print "Average date is: "+calendar.month_name[averageMonth] + " " + str(averageYear)
    
