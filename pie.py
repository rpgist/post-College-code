#James Hawkins

import calendar
import os
import glob

#convert takes the date string and converts it to an list containg the date in month as an int
#followd by the year as an int
def convert(date):
    date= date.split("[")[0]
    datewords = date.split()
    if(len(datewords)>2):
        date = datewords[0]+" "+datewords[2]
    #print "this is date "+date
    if("january" in date):
        date = date.strip('january,')
        result = [1]
        result.append(int(date.strip()))
        return result
    elif("february" in date):
        date = date.strip('february,')
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
    #for some reason it kept chopping off the de in december but this catches that
    elif("december" in date or "cember" in date): 
        date = date.strip('december,')
        result = [12]
        result.append(int(date.strip())) 
        return result
    else:
        print "invalid string: "+date
        result = ['go', 'fish']
        return result

#gets the directory to parse for .txt files
dname = raw_input('Enter path: ')
files = [f for f in glob.glob(dname +"**/*.txt")]
monthList = []
yearList = []
#goes through each file and parses individually 
for f in files:
    fileObject = open(f, 'r')
    for line in fileObject:
        #checks if line contains release date
        if("release date:" in line.lower()):
            line = line.strip('Release Date:')
            if("updated:" in line.lower() or "original" in line.lower()):
                temp = ['go']
            else:
                #calls the convert function to process the date
                temp =convert(line.lower())
                if('go' in temp):
                    print "invalid date in file "+ line 
                else:
                    #adds the months and year to lists 
                    monthList.append(temp[0])
                    yearList.append(temp[1])

#gets the average year and month from the lists
averageMonth = sum(monthList) / len(monthList)
averageYear = sum(yearList) / len(yearList)
print "Average date is: "+calendar.month_name[averageMonth] + " " + str(averageYear)
    
