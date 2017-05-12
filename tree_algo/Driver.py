import numpy as np

from pandas import DataFrame, read_csv

from sklearn.ensemble import RandomForestClassifier

# Read in data and properly set up pandas DataFrame
df = read_csv('../testData.txt', header=None, sep='\t')
df.dtype = np.float32
df.columns = ['x','y','z']

# Set up labels
labels = [(i,j) for i in range(10) for j in range(10) ]
labels += labels

# Add labels to DataFrame
df['key'] = labels

# Create and train classifier
clf = RandomForestClassifier()
clf.fit(df[['x','y','z']].as_matrix(), labels)


# Testing time
correct = 0

# Get all predictions off training data
# We can predict off of training data, because there is a finite number of
# samples we can have for this problem
preds = clf.predict(df[['x','y','z']].as_matrix())

# Get accuracy of predictions
for i, j in zip(labels, preds):
    print i, j
    if i[0] == j[0] and i[1] == j[1]:
        correct += 1

print 'Accuracy:', float(correct) / len(labels)
