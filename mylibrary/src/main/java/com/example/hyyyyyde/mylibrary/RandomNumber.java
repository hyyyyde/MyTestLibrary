package com.example.hyyyyyde.mylibrary;


import android.os.Handler;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ランダムな数字を通知するクラス
 */
public class RandomNumber {
    private static final int DELAY_MILLI_SECOND = 3000;

    /**
     * オブザーバーリスト
     */
    private CopyOnWriteArrayList<EventObserver> mObservers = new CopyOnWriteArrayList<EventObserver>();

    /**
     * オブザーバーの取得
     *
     * @return オブザーバー
     */
    private CopyOnWriteArrayList<EventObserver> getObservers() {
        return mObservers;
    }

    /**
     * Observerを追加
     *
     * @param observer observer
     */
    public void addObserver(EventObserver observer) {
        mObservers.add(observer);
    }

    /**
     * Observerを削除
     *
     * @param observer observer
     */
    public void deleteObserver(EventObserver observer) {
        mObservers.remove(observer);
    }

    private void notifyObserver(Event event) {
        CopyOnWriteArrayList<EventObserver> observers = getObservers();
        for (EventObserver observer : observers) {
            observer.onNotify(event);
        }
    }

    private Handler mHandler = new Handler();

    /**
     * 単純なタイマー
     * @param maxNumber
     */
    public void request(final Integer maxNumber) {

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();

                Event event = new Event();
                event.setNumber(String.valueOf(random.nextInt(maxNumber) + 1));

                notifyObserver(event);

                mHandler.postDelayed(this, DELAY_MILLI_SECOND);
            }
        }, DELAY_MILLI_SECOND);
    }
}
