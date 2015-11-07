(ns vhura.client
  (:import [com.yubico.client.v2 YubicoClient]))


(defn get-id [client]
  (.getClientId client))

(defn set-id [client id]
  (.setClientId client (int id))
  client)


(defn get-key [client]
  (.getClientKey client))

(defn set-key [client key]
  (.setClientKey client key)
  client)


(defn set-sync [client sync]
  (.setSync client (int sync))
  client)

(defn get-wsapi-urls [client]
  (vec (.getWsapiUrls client)))

(defn set-wsapi-urls [client urls]
  (.setWsapiUrls client (java.util.ArrayList. urls)))

(defn set-useragent [client useragent]
  (.setUserAgent client useragent)
  client)

(defn get-public-id [otp]
  (YubicoClient/getPublicId otp))

(defn valid-otp-format? [otp]
  (YubicoClient/isValidOTPFormat otp))
