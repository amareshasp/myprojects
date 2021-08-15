import React from "react";
import SubList from "./SubCreate";

class SubView extends React.Component {
  state = {
    bookDetails: [
      {
        index: Math.random(),
        agency: "",
        channel: "",
      },
    ],
  };
  handleChange = (e) => {
    if (
      ["name", "author", "type", "dateOfPublish", "price"].includes(
        e.target.name
      )
    ) {
      let bookDetails = [...this.state.bookDetails];
      bookDetails[e.target.dataset.id][e.target.name] = e.target.value;
    } else {
      this.setState({ [e.target.name]: e.target.value });
    }
  };
  addNewRow = (e) => {
    this.setState((prevState) => ({
      bookDetails: [
        ...prevState.bookDetails,
        {
          index: Math.random(),
          name: "",
          author: "",
          type: "",
          dateOfPublish: "",
          price: "",
        },
      ],
    }));
  };

  deteteRow = (index) => {
    this.setState({
      bookDetails: this.state.bookDetails.filter(
        (s, sindex) => index !== sindex
      ),
    });
  };

  clickOnDelete(record) {
    this.setState({
      bookDetails: this.state.bookDetails.filter((r) => r !== record),
    });
  }
  render() {
    let { bookDetails } = this.state;
    return (
      <SubList
        add={this.addNewRow}
        delete={this.clickOnDelete.bind(this)}
        bookDetails={bookDetails}
      />
    );
  }
}
export default SubView;
