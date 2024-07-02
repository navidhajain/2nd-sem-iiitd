data = '\nOthers\n51 Bablu Mali,\n52 Kishan Lal (Tailor),\n\t\nHOUSEKEEPING\n101 Dhan Singh,\n102 Fazil,\n103 Ganesh,\n104 Kailash,\n105 Monu,\n106 Pawan,\n107 Ram Sumer,\n108 Ramkesh,\n109 Santu Lal,\n110 Saurabh,\n111 Shekhar,\n112 Sushil Kumar Sahu,\n113 Vikram Nishad,\n114 Vishal,\n\t\nRESTAURANT\n201 Anant Ram,\n202 Anil Pantry,\n203 Deepak Steward,\n204 Dhan Bhaudur,\n205 Harsh (UT),\n206 Jitendra Patel,\n207 Kuldeep Helper,\n208 Mahesh (UT),\n209 Mukesh,\n210 Nandu (UT),\n211 Raju Thomas,\n212 Ram Bali (UT),\n213 Ramesh Dubey,\n214 Ramnath,\n215 Rinku,\n216 Shobhit Helper,\n217 Subhash Rana,\n218 Suresh Kumar-Tandoor,\n\t\nBANQUET\n301 Anand Sachdeva,\n302 Anil Tandoor,\n303 Ankit Singh,\n304 Arun,\n305 Azad,\n306 Basant Steward,\n307 Beeru (UT),\n308 Brijesh (UT),\n309 Chotu (Suresh Kumar Verma),\n310 Dheer Singh,\n311 Kamal Kishore,\n312 Karan (Gokarna Bahadur),\n313 Madan Joshi,\n314 Mahendra,\n315 Manish Manager,\n316 Omi (Om Bahadur Ale),\n317 Piyush,\n318 Pradeep,\n319 R.K.Pal,\n320 R.K.Rawat (Ram Kumar Rawat),\n321 Raju Steward,\n322 Ram Kumar,\n323 Ram Prasad Helper,\n324 Ram Singh,\n325 Ramesh Mourya,\n326 Rocky (Rakha Bahadur Thapa),\n327 Sanjay Singh,\n328 Saurabh,\n329 Sonu Saini,\n330 Luvkush,\n331 Suresh Tiwari 1/Maharaj,\n332 Surjeet Steward,\n333 Vaibhav Mishra,\n334 Virendra (UT),\n335 Vishal Sahu,\n\t\nRoom Service\n501 Babu Ram,\n502 Chander Singh,\n503 Dharmesh Pandey,\n504 Ramesh Mishra,\n505 Subhash Verma,\n506 Sunil Kumar Gupta,\n507 Umesh Kalwani,\n508 Vijay Kumar Sahu,\n\t\nGuards\n601 Dileep Kr. Sharma,\n602 R.B. Singh,\n603 Rajesh Kumar Mishra,\n604 Udai Bhan Singh\n\t\nStore Staff\n651 Ajay Kumar,\n652 Ankit Kumar,\n653 Durgesh,\n654 Jitendra Tripathi,\n655 Vimal,\n\t\nFront Office\n701 Ajay Diwedi,\n702 Jairam Mishra,\n703 Jalees Malik,\n704 Rakesh Pandey,\n705 Rohit Jaiswal,\n706 Sandeep Sharma,\n707 Sunil Kumar Maurya,\n708 Vaibhav Joshi,\n\t\nCleaning Staff\n751 Amit Supervisor,\n752 Badshah Khan,\n753 Bobby,\n754 Deepu I,\n755 Dharmesh,\n756 Kripa Shankar,\n757 Monti,\n758 Prem Nath,\n759 Rajkumar(GS),\n760 Ravi,\n761 Rupesh,\n762 Poonam,\n763 Tara,\n764 Sonu,\n765 Tushar,\n\t\nDrivers\n801 Akram Ali, \n802 Bajrang,\n803 Vinay Yadav,\n804 Vishesh Shukla,\n\t\nMarketing Staff\n851 Amit Chaurasia,\n852 Deepu,\n853 Jitendra Yadav,\n854 Kanhaiya Lal,\n855 Ramu (Night Shift),\n856 Shobhit,\n\t\nPlumbers\n901 Brijesh Yadav, \n902 Sunil Kumar (Plumber),\n\t\nAccounts\n951 Alok, \n952 Anupam,\n953 Harshit,\n\t\n\n\t\n\t\n\t\n\t\n\t\n\t\n\t\n\t\n\t\n\t\n\t\n\t\n\t\n\t\n'
dictionary={}
x = data.split('\t')
for block in x: 
  # print(block)
  lines=block.split('\n')
  # print(lines)
  dictkey=lines[1]
  # print(dictkey)
  dictsmall={}
  for line in lines[2:-1]:
    # print("lines")
    # print(line)
    words=line.split(' ')
    # print("words")
    # print(words)
    dictkey2=words[0]
    # print('d2')
    # print(dictkey2)
    # print(words[1:])
    
    dictvalues=''
    for ows in words[1:]:
        # print("ows")
        # print(ows)       
        dictvalues=dictvalues+ows+' '
    # print('dv')
    # print(dictvalues[:-2])
    dictsmall[dictkey2]=dictvalues[:-2]
    # print(dictsmall)
  dictionary[dictkey]=dictsmall 
print(dictionary)
