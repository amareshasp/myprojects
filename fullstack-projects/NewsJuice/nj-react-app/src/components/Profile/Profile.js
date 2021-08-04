import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import styles from "./Profile.module.css";
import TextField from "@material-ui/core/TextField";
import Icon from "@material-ui/core/Icon";
import SaveIcon from "@material-ui/icons/Save";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import Accordion from "@material-ui/core/Accordion";
import AccordionSummary from "@material-ui/core/AccordionSummary";
import AccordionDetails from "@material-ui/core/AccordionDetails";
import Typography from "@material-ui/core/Typography";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";

function Profile(props) {
  const [name, setName] = useState("");

  const handleSubmit = (evt) => {
    evt.preventDefault();
    alert(`Submitting Name ${name}`);
  };

  return (
    <Box display="flex">
      <form className={styles.accord} noValidate autoComplete="off">
        <Accordion>
          <AccordionSummary
            expandIcon={<ExpandMoreIcon />}
            aria-controls="panel1a-content"
            id="panel1a-header"
          >
            <Typography>USER</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <TextField
                id="standard-basic"
                label="Name"
                className={styles.formfield}
                onChange={(e) => setName(e.target.value)}
              />
              <TextField
                id="standard-basic"
                label="Surname"
                className={styles.formfield}
              />
              <TextField
                id="standard-basic"
                label="Age"
                className={styles.formfield}
              />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<ExpandMoreIcon />}
            aria-controls="panel1a-content"
            id="panel1a-header"
          >
            <Typography>SUBSCRIPTION</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <TextField
                id="standard-basic"
                label="Agency"
                className={styles.formfield}
                onChange={(e) => setName(e.target.value)}
              />
              <TextField
                id="standard-basic"
                label="Channel"
                className={styles.formfield}
              />
              <TextField
                id="standard-basic"
                label="Filter"
                className={styles.formfield}
              />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Box display="flex" flexDirection="row-reverse">
          <Button
            variant="contained"
            color="primary"
            size="large"
            className={styles.button}
            startIcon={<SaveIcon />}
            onClick={handleSubmit}
          >
            Save
          </Button>
        </Box>
      </form>
    </Box>
  );
}
export default Profile;
