import 'Jsencrypt'
let pkey = 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhefq1bFi3e+geJvVry8bar87ZsY3pljbnPM6XAkHo8CngCrjiVhNpVxcrPrvJrNTp3CcwBqOw7BlaLJB3rQL+okxMrlJ2QnaMJg9BCV6C+Zk+giqWKXz76x5nq0MmvNdKH+VjZIT2UDnAUMm+fi1pAI8QLNGgRktDug64/NB77PXSHDLClSP/AI4HJvt7wifN/NafXtyM3IUj8mqL6Pab5DZqlbF5qQcO16yX9uC/Y1v2ZUfe6m4UTsvMYpi6QQq5uhwM0+vaw0B16+8qleKi+gOicM5HHFtICvWH8n5d3OMAGgsLmX+BBLg6+AAnc9b2l/RGn/PjHXkR1xTbpTfEQIDAQAB'

let encrypt=new JSEncrypt();
encrypt.setPublicKey(pkey);

export function infoEncrypt(str) {
  return encrypt.encrypt(str)
}
