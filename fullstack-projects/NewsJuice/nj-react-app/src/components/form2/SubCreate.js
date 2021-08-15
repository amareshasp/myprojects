import React from "react";
import TextField from "@material-ui/core/TextField";
import styles from "./Sub.module.css";
import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";
import InputLabel from "@material-ui/core/InputLabel";
import Button from "@material-ui/core/Button";
import Add from "@material-ui/icons/Add";
import Checkbox from "@material-ui/core/Checkbox";
import FormControlLabel from "@material-ui/core/FormControlLabel";
const SubList = (props) => {
  const [isEvent, setEvent] = React.useState(false);
  const [isSport, setSport] = React.useState(false);

  const handleEventChange = (event) => {
    setEvent(event.target.checked);
  };
  const handleSportChange = (event) => {
    setSport(event.target.checked);
  };
  const [state, setState] = React.useState({
    age: "",
    name: "hai",
  });
  const handleChange = (event) => {};

  return props.bookDetails.map((val, idx) => {
    let name = `name-${idx}`,
      dateOfPublish = `dateOfPublish-${idx}`,
      type = `type-${idx}`,
      price = `price-${idx}`;
    return (
      <div key={val.index}>
        <Select
          native
          value={state.age}
          onChange={handleChange}
          label="Age"
          inputProps={{
            name: "age",
            id: "age-native-simple",
          }}
          className={styles.sfield}
        >
          <option value="" disabled>
            Agency
          </option>
          <option value="TOI">TOI</option>
          <option value="The Hindu">The Hindu</option>
          <option value="Hindustan">Hindustan</option>
        </Select>

        <FormControlLabel
          control={
            <Checkbox
              checked={state.checkedB}
              onChange={(e) => handleEventChange(e.target.checked)}
              name="checkedB"
              color="primary"
            />
          }
          label="Events"
        />

        <FormControlLabel
          control={
            <Checkbox
              checked={state.checkedB}
              onChange={handleSportChange}
              name="checkedB"
              color="primary"
            />
          }
          label="Sports"
        />

        <span className={styles.ffield}>&nbsp;</span>
        {idx === 0 ? (
          <Button
            variant="contained"
            color="primary"
            size="small"
            className={styles.button}
            startIcon={<Add />}
            onClick={() => props.add()}
          >
            ADD
          </Button>
        ) : (
          <button className="btn btn-danger" onClick={() => props.delete(val)}>
            Remove
          </button>
        )}
      </div>
    );
  });
};
export default SubList;
