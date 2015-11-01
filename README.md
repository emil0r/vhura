# vhura

Wrapper for the Yubikey java validation client


## YubiKey?

Read more at https://www.yubico.com/


## Usage

```clojure

(require '[vhura.core :as vhura])

(let [client (vhura/get-client 12346 "mykey")]
  (vhura/verify client "my-otp-here"))
  
;;
;; will give back a map the following key/values. taken from the code living in core
;;
;; {:ok? (.isOk response)
;;  :H (.getH response)
;;  :T (.getT response)
;;  :timestamp (.getTimestamp response)
;;  :session/counter (.getSessioncounter response)
;;  :session/use (.getSessionuse response)
;;  :sl (.getSl response)
;;  :otp (.getOtp response)
;;  :nonce (.getNonce response)
;;  :public-id (.getPublicId response)
;;
;;  :status/error? (.. response getStatus isError)
;;  :status (condp = (.getStatus response)
;;
;;            ;; The OTP has already been seen by the service
;;            ResponseStatus/REPLAYED_OTP :replayed-otp
;;
;;            ;; Unexpected error in our server. Please contact us if you see this error.
;;            ResponseStatus/BACKEND_ERROR :backend-error
;;
;;            ;; The OTP is invalid format
;;            ResponseStatus/BAD_OTP :bad-otp
;;
;;            ;; The HMAC signature verification failed
;;            ResponseStatus/BAD_SIGNATURE :bad-signature
;;
;;            ;; The request id does not exist
;;            ResponseStatus/NO_SUCH_CLIENT :no-such-client
;;
;;            ;; The request lacks a parameter
;;            ResponseStatus/MISSING_PARAMETER :missing-parameter
;;
;;            ;; The request id is not allowed to verify OTPs
;;            ResponseStatus/OPERATION_NOT_ALLOWED :operation-not-allowed
;;
;;            ;; Server could not get requested number of syncs during before timeout
;;            ResponseStatus/NOT_ENOUGH_ANSWERS :not-enough-answers
;;
;;            ;; Server has seen the OTP/Nonce combination before, see http://forum.yubico.com/viewtopic.php?f=3&t=701
;;            ResponseStatus/REPLAYED_REQUEST :replayed-request
;;
;;            ;; The OTP is valid
;;            ResponseStatus/OK :ok
;;
;;            ;; missing an enum
;;            (.getStatus response))}
```

## License

Copyright © 2015 Emil Bengtsson

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.



Coram Deo
