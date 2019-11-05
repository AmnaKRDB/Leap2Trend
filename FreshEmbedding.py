'''
TRAIN MODEL
Takes a text file, trains it into a word2vec model.
REQUIRES
+ gensim
'''
import warnings
warnings.filterwarnings(action='ignore', category=UserWarning, module='gensim')
from gensim import models, matutils


input_filename =  'D:/MICCAI/Incremental Windows/2004-2018/Bigram2004_2018.txt'		# file of text to train on
model_filename =  'D:/MICCAI/Incremental Windows/2004-2018/Bigram2004_2018.model'		# name for saving trained model

# train using skip-gram?
# (ignore unless you wanna do detailed tweaking)
skip_gram = 	  True


# create vocabulary
print ('building vocabulary...')
model = models.Word2Vec()
sentences = models.word2vec.LineSentence(input_filename)
model.build_vocab(sentences)
bigram_transformer = models.Phrases(sentences)
model = models.Word2Vec(bigram_transformer[sentences], size=200, min_count=5, window=6)



# train model
print ('training model...')
if skip_gram:
    #model.train(bigram_transformer[sentences], sg=1)
    model.train(bigram_transformer[sentences], total_examples=model.corpus_count, epochs=model.iter)
    #(sentences, total_examples= model.corpus_count, epochs= model.iter)
else:
    #model.train(sentences)
    model.train(bigram_transformer[sentences], total_examples=self.corpus_count, epochs=self.iter, size=200, min_count=5, window=6)


# and save
print ('- saving model...')
model.save(model_filename)

# bye
print ('all done, thank you!')
