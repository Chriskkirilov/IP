import axios from "axios";

const POLL_API_BASE_URL = "http://localhost:8080/findAll"
class PollService {

    getPolls() {
        return axios.get(POLL_API_BASE_URL);
    }

}
export default new PollService()