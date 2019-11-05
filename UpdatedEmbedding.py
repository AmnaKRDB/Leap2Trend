from gensim import models, matutils
import numpy as np 									# array handling
import os, warnings


model_filename =    'D:/MICCAI/MICCAI Corpora/2017/Bigram2017.model'
input_filename =  'D:/MICCAI/MICCAI Corpora/2018/Bigrams2018.txt'
newModel_filename =  'D:/MICCAI/MICCAI Corpora/2018/Bigram2018.model'

# ignore unicode warnings
# (they don't cause any problems, just ugly output from this code)
warnings.filterwarnings('ignore', '.*Unicode.*')

# load existing model from file
print ('loading model...') 
model = models.Word2Vec.load(model_filename)
print ('- done')

new_sentences = models.word2vec.LineSentence(input_filename)
model.build_vocab(new_sentences, update=True)
#model.train(new_sentences)
bigram_transformer = models.Phrases(new_sentences)
model.train(bigram_transformer[new_sentences], total_examples=model.corpus_count, epochs=model.iter)
model.save(newModel_filename)

# bye
print ('all done, thank you!')
