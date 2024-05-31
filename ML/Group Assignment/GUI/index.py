import streamlit as st
import pickle
import pandas as pd
from math import ceil

# Load the trained models
model = pickle.load(open('/home/adane/AASTU_swe/ML/Group Assignment/model/salary predictor(dtr).pkl', 'rb'))
df=pickle.load(open('/home/adane/AASTU_swe/ML/Group Assignment/model/df.pkl', 'rb'))
# Define the unique job titles
job_titles = df.columns[5:].tolist()
# st.write(job_titles)
education_list = ["High School", "Bachelor's", "Master's", "PhD"]



def app():
    st.title('Salary Predictor')
    

    # Create input fields
    age = st.number_input('Age', min_value=0)
    gender = st.selectbox('Gender', ['Male', 'Female'])
    education_level = st.selectbox('Education Level', education_list)
    job_title = st.selectbox('Job Title', job_titles)
    years_experience = st.number_input('Years of Experience', min_value=0.0)

    edu={"High School": 0, "Bachelor's": 1, "Master's": 2, "PhD": 3}
    education_level=edu[education_level]

    

    # Create predict button
    if st.button('Predict Salary'):
        # Create a dataframe from the inputs
        input_data = pd.DataFrame({
            'Age': [age],
            'Gender': [gender=='Male'],
            'Education Level': [education_level],
            'Years of Experience': [years_experience]
        })
        # Create columns for each job title, all set to 0
        for title in job_titles:
            input_data[title] = 0

        # Set the job title that was selected to 1
        input_data[job_title] = 1
    
        
         # Use the model to make a prediction
        prediction = model.predict(input_data)

        # Display the prediction
        st.write(f'The predicted salary is: {ceil(prediction[0])}$ yearly')

# Run the app
if __name__ == '__main__':
    app()