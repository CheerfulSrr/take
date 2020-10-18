import Axios from 'axios'
import qs from 'query-string'

const axios = Axios.create({
  paramsSerializer: params => qs.stringify(params),
  xsrfCookieName: "csrf_token",
  timeout: 3000
});


export {
  axios
}