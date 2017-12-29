package motoband.com.motobands.model.http.manager;


/**
 * Created by hua on 2016/4/16.
 */
public class ClientUpdateManager {

    private static ClientUpdateManager instance;

    private ClientUpdateManager() {
    }

    public static ClientUpdateManager getInstance() {
        if (instance == null) {
            synchronized (ClientUpdateManager.class) {
                if (instance == null) {
                    instance = new ClientUpdateManager();
                }
            }
        }
        return instance;
    }

 /*   public Observable<UpdateVersionModel> getClientUpdateConfig() {
        Observable<ResponseBody> observable = new RetrofitHelper.Builder()
                .build(ClientUpdateService.class)
                .getClientUpdateConfig(RetrofitHelper.getRequestBody(null));

        return RetrofitHelper.getJsonObservable(observable)
                .map(new Function<String, UpdateVersionModel>() {
                    @Override
                    public UpdateVersionModel apply(@NonNull String s) throws Exception {
                        JSONObject jsonObject = JSON.parseObject(s);

                        List<OpenScreenModel> openScreenModels = null;
                        if (jsonObject.containsKey(MBResponseConstants.MAP)) {
                            JSONObject map = jsonObject.getJSONObject(MBResponseConstants.MAP);
                            if (map.containsKey("openscreenlist")) {
                                openScreenModels = JSON.parseArray(map.getString("openscreenlist"), OpenScreenModel.class);
                            }
                        }
                        ClientUpdateDao.deleteAndInsertOpenScreenModels(openScreenModels);

                        if (jsonObject.containsKey(MBResponseConstants.DATA)) {
                            return JSON.parseObject(jsonObject.getString(MBResponseConstants.DATA), UpdateVersionModel.class);
                        } else {
                            throw new MBException(MBResponseCode.RESPONSE_DATA_ERROR);
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }*/

  /*  public Observable<OpenScreenModel> getOpenScreenRandom() {
        return Observable.create(new ObservableOnSubscribe<OpenScreenModel>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<OpenScreenModel> e) throws Exception {
                List<OpenScreenModel> openScreenModels = ClientUpdateDao.selectOpenScreenRandom(1);
                if (openScreenModels != null && openScreenModels.size() > 0 && openScreenModels.get(0) != null) {
                    e.onNext(openScreenModels.get(0));
                    e.onComplete();
                } else {
                    e.onError(new MBException(MBResponseCode.NO_DATA));
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }*/

}
