f = open("LIST.txt")
d = '\t' + f.read()
filedata = d.split('\n')
employee_data = {}
i = 0
dept = ""
while i < len(filedata):
  if filedata[i] == '\t':
    i += 1
    dept = filedata[i]
    if dept != "" and dept != "\t":
      employee_data[dept] = {}      
  else:
    emp = [filedata[i][:filedata[i].find(" ")], filedata[i][filedata[i].find(" ") + 1: -1]]
    if dept != "" and dept != "\t":
      employee_data[dept][emp[0]] = emp[1]
  i += 1
print(employee_data)