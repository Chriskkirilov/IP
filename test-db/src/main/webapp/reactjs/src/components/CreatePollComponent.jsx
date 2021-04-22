import React, {Component} from 'react';

class CreatePollComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            title:'',
            description:''
        }

        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changeDescriptionHandler = this.changeDescriptionHandler.bind(this);
        this.savePoll = this.savePoll.bind(this);
    }

    savePoll = (p) => {
        p.preventDefault();
        let poll = {title: this.state.title, description: this.state.description};
        console.log('poll=>' + JSON.stringify(poll));
    }

    changeTitleHandler= (event) => {
        this.setState({title: event.target.value});
    }

    changeDescriptionHandler= (event) => {
        this.setState({description: event.target.value});
    }

    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add a poll</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Title:</label>
                                        <input
                                            placeholder="title" name="title" className="form-control"
                                            value={this.store.title} onChange={this.changeTitleHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Description:</label>
                                        <input
                                            placeholder="Description" name="description" className="form-control"
                                            value={this.store.description} onChange={this.changeDescriptionHandler}
                                        />
                                    </div>

                                    <button className="btn btn-success" onClick={this.savePoll}>Save</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreatePollComponent;