import React, {Component, useRef, useState} from 'react';
import axios from 'axios';


function AddPoll() {
    const [answers, setAnswers] = useState([]);
    const answerTextRef =useRef();
    const [next_id, setNextId] = useState(1);

    function increment() {
        setNextId((aid) => {
            return aid + 1;
        });
    }

    function handlerAddAnswer() {
        setAnswers([
            ...answers,
            {
                question: answerTextRef.current.value
            },
        ]);
        increment();
    }

    function getQuestionText() {
        return document.getElementById("question").value;
    }

    function getDescriptionText() {
        return document.getElementById("description").value;
    }

    function checkLength() {
        alert("Please add more answers");
    }

    function handleCreateForm() {
        if(answers.length < 2) {
            return checkLength();
        }
        else {
            axios.post("http://localhost:8080/addPoll",
                {title: getQuestionText(), description: getDescriptionText(), answers: answers},
            )
        }
    }
    console.log(answers.length);

    function testVoting() {
        setAnswers([
            ...answers,
            {
                votes: answerTextRef.current.value
            },
        ]);
    }

    return (
        <form>
            <div className="form-group">
                <label htmlFor="exampleInputEmail1">Question</label>
                <input type="text" className="form-control" id="question" placeholder="Enter question"/>
            </div>
            <div className="form-group">
                <label htmlFor="exampleInputPassword1">Description</label>
                <input type="text" className="form-control" id="description" placeholder="Enter description"/>
            </div>
            <div className="form-group">
                <label htmlFor="exampleInputPassword1">Options</label>
                <input type="text" ref={answerTextRef} className="form-control" placeholder="Enter your options"/>
            </div>
            <button type="button" className="btn btn-outline-success btn-lg btn-block" onClick={handlerAddAnswer}>Add option</button>
            <br/>
            <button type="button" className="btn btn-outline-secondary btn-lg btn-block" onClick={handleCreateForm}>Create form</button>

        </form>


    )
} export default AddPoll;