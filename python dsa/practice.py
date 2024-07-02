from urllib import urlopen
wordsurl = "http://learncodethehardway.org/words.txt"
words=[]
phrases= {


 "class %%%(%%%):":
  "Make a class named %%% that is-a %%%.",




 "class %%%(object):\n\tdef __init__(self, ***)" :
 "class %%% has-a __init__ that takes self and *** parameters.",
 "class %%%(object):\n\tdef ***(self, @@@)":
 "class %%% has-a function named *** that takes self and @@@ parameters.",
 "*** = %%%()":
 "Set *** to an instance of class %%%.",
 "***.***(@@@)":
 "From *** get the *** function, and call it with parameters self, @@@.",
 "***.*** = '***'":
 "From *** get the *** attribute and set it to '***'."
 }  

for word in urlopen(wordsurl).readlines():
  words.append(word)

def convert(snippet, phrase):
  classnames=[w.capitalize for w in random.sample(words, snippet.count('%%%'))]
  othernames=random.sample(words, snippet.count('***'))
  results=[]
  paranames=[]

  for i in range(0, snippet.count('@@@')):
    paracount=random.randint(1,3)
    paranames.append(','.join(random.sample(words, paracount)))

  for sentence in snippet, phrase:
    	result=sentence[:] 

	  for word in classnames:
	    result=result.replace('%%%', word, 1)

	  for word in othernames:
	    result=result.replace('***', word, 1)

	  for word in paranames:
	     result = result.replace("@@@", word, 1)

	  results.append(result)   
  return results

try:
    while True:
       snippets = phrases.keys()
       random.shuffle(snippets)
       for snippet in snippets:
          phrase = PHRASES[snippet]
          question, answer = convert(snippet, phrase)
          
          print(question)
            input("> ")
            print("ANSWER: %s\n\n" % answer)

except EOFError:
 print("\nBye") 
