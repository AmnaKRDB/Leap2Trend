# Leap2Trend
Leap2Trend is a novel approach to instant detection of research trends. 
It relies on temporal word embeddings word2vecto track the dynamics
of similarities between pairs of keywords, their rankings and respective uprankings (ascents) over time.

Leap2Trend has been developed with Python and Java following a pipline project.

#INSTALLATION
1) Python 2.7
2) Java 8


#ROAD MAP

Python has been used for the embedding phase. Two codes have been provided: the first one (FreshEmbedding.py) for word2vec training from scratch and the second one (UpdatedEmbedding.py) for updating word2vec pretrained model with new vocabulary. Recall that Gensim Python Library has to be installed in order to use the Word2vec package. 


 *) FreshEmbedding.py: This code serves to train a word2vec model from scratch. It takes as input a text file and returns a word2vec model.

*) UpdatedEmbedding.py: This code serves to update a word2vec trained model. It takes as input a pre-trained model and a new vocabulary, and returns an updated word2vec model with new vector representations of words.

After each training, the similarity function similarity(word1,word2) has to be applied to find the similarity measures between the couple of keywords being studied and the result could be saved in text file. 

Java has been used for the postprocessing phase. The description of the used codes is given as follows: 

*) MatrixFromFile.java: this code serves to create a [k*k] matrix from a text file. The text file is the output of the similarity function above and the matrix corresponds to top k similarity matrix that stores the cosine similarity between embedding vectors of k pairs of keywords. 

*) RankingMatrix.java: this code serves to rank the similarity matrix and returns the positions of ranked couple of keywords.

*) FindingPosition.java: this code serves to return the list of ranked keywords at a specific window of time.

*) RankExtraction.java: this code serves to return the rank of each keyword at all windows.

*) Jump.java: this code computes the jumps of a couple of keywords over all windows. 

*) Slope: this code computes the slope of the linear regression of Google Trends hits.

*) CountGoogleTrends: this code counts the Google Trends hits per year from the csv file returned by Google Trend.

