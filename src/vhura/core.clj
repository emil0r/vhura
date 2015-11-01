(ns vhura.core
  (:import [com.yubico.client.v2 YubicoClient ResponseStatus]))

(defn get-client [client-id key]
  (YubicoClient/getClient (int client-id) key))


(defn verify [client otp]
  (let [response (.verify client otp)]
    {:ok? (.isOk response)
     :H (.getH response)
     :T (.getT response)
     :timestamp (.getTimestamp response)
     :session/counter (.getSessioncounter response)
     :session/use (.getSessionuse response)
     :sl (.getSl response)
     :otp (.getOtp response)
     :nonce (.getNonce response)
     :public-id (.getPublicId response)

     :status/error? (.. response getStatus isError)
     :status (condp = (.getStatus response)

               ;; The OTP has already been seen by the service
               ResponseStatus/REPLAYED_OTP :replayed-otp

               ;; Unexpected error in our server. Please contact us if you see this error.
               ResponseStatus/BACKEND_ERROR :backend-error

               ;; The OTP is invalid format
               ResponseStatus/BAD_OTP :bad-otp

               ;; The HMAC signature verification failed
               ResponseStatus/BAD_SIGNATURE :bad-signature

               ;; The request id does not exist
               ResponseStatus/NO_SUCH_CLIENT :no-such-client

               ;; The request lacks a parameter
               ResponseStatus/MISSING_PARAMETER :missing-parameter

               ;; The request id is not allowed to verify OTPs
               ResponseStatus/OPERATION_NOT_ALLOWED :operation-not-allowed

               ;; Server could not get requested number of syncs during before timeout
               ResponseStatus/NOT_ENOUGH_ANSWERS :not-enough-answers

               ;; Server has seen the OTP/Nonce combination before, see http://forum.yubico.com/viewtopic.php?f=3&t=701
               ResponseStatus/REPLAYED_REQUEST :replayed-request

               ;; The OTP is valid
               ResponseStatus/OK :ok

               ;; missing an enum
               (.getStatus response))}))
