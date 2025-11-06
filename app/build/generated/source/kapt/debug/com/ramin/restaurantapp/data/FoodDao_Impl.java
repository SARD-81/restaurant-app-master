package com.ramin.restaurantapp.data;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FoodDao_Impl implements FoodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FoodEntity> __insertionAdapterOfFoodEntity;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public FoodDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFoodEntity = new EntityInsertionAdapter<FoodEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `food` (`id`,`name`,`category_1`,`category_2`,`description`,`photo`,`video`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FoodEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getCategoryLevel1() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCategoryLevel1());
        }
        if (value.getCategoryLevel2() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCategoryLevel2());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescription());
        }
        if (value.getPhoto() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhoto());
        }
        if (value.getVideo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getVideo());
        }
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM food";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final List<FoodEntity> items) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFoodEntity.insert(items);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clear() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClear.release(_stmt);
    }
  }

  @Override
  public Flow<List<FoodEntity>> getAllFoods() {
    final String _sql = "SELECT * FROM food ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<List<FoodEntity>>() {
      @Override
      public List<FoodEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategoryLevel1 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_1");
          final int _cursorIndexOfCategoryLevel2 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_2");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final List<FoodEntity> _result = new ArrayList<FoodEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FoodEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategoryLevel1;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel1)) {
              _tmpCategoryLevel1 = null;
            } else {
              _tmpCategoryLevel1 = _cursor.getString(_cursorIndexOfCategoryLevel1);
            }
            final String _tmpCategoryLevel2;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel2)) {
              _tmpCategoryLevel2 = null;
            } else {
              _tmpCategoryLevel2 = _cursor.getString(_cursorIndexOfCategoryLevel2);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final String _tmpVideo;
            if (_cursor.isNull(_cursorIndexOfVideo)) {
              _tmpVideo = null;
            } else {
              _tmpVideo = _cursor.getString(_cursorIndexOfVideo);
            }
            _item = new FoodEntity(_tmpId,_tmpName,_tmpCategoryLevel1,_tmpCategoryLevel2,_tmpDescription,_tmpPhoto,_tmpVideo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<String>> getLevelOneCategories() {
    final String _sql = "SELECT DISTINCT category_1 FROM food ORDER BY category_1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<String>> getSubcategoriesFor(final String category) {
    final String _sql = "SELECT DISTINCT category_2 FROM food WHERE category_1 = ? AND category_2 IS NOT NULL AND category_2 != '' ORDER BY category_2";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<FoodEntity>> getFoodsForCategory(final String category) {
    final String _sql = "SELECT * FROM food WHERE category_1 = ? AND (category_2 IS NULL OR category_2 = '') ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<List<FoodEntity>>() {
      @Override
      public List<FoodEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategoryLevel1 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_1");
          final int _cursorIndexOfCategoryLevel2 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_2");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final List<FoodEntity> _result = new ArrayList<FoodEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FoodEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategoryLevel1;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel1)) {
              _tmpCategoryLevel1 = null;
            } else {
              _tmpCategoryLevel1 = _cursor.getString(_cursorIndexOfCategoryLevel1);
            }
            final String _tmpCategoryLevel2;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel2)) {
              _tmpCategoryLevel2 = null;
            } else {
              _tmpCategoryLevel2 = _cursor.getString(_cursorIndexOfCategoryLevel2);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final String _tmpVideo;
            if (_cursor.isNull(_cursorIndexOfVideo)) {
              _tmpVideo = null;
            } else {
              _tmpVideo = _cursor.getString(_cursorIndexOfVideo);
            }
            _item = new FoodEntity(_tmpId,_tmpName,_tmpCategoryLevel1,_tmpCategoryLevel2,_tmpDescription,_tmpPhoto,_tmpVideo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<FoodEntity>> getFoodsForSubcategory(final String category,
      final String subcategory) {
    final String _sql = "SELECT * FROM food WHERE category_1 = ? AND category_2 = ? ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    _argIndex = 2;
    if (subcategory == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, subcategory);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<List<FoodEntity>>() {
      @Override
      public List<FoodEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategoryLevel1 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_1");
          final int _cursorIndexOfCategoryLevel2 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_2");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final List<FoodEntity> _result = new ArrayList<FoodEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FoodEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategoryLevel1;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel1)) {
              _tmpCategoryLevel1 = null;
            } else {
              _tmpCategoryLevel1 = _cursor.getString(_cursorIndexOfCategoryLevel1);
            }
            final String _tmpCategoryLevel2;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel2)) {
              _tmpCategoryLevel2 = null;
            } else {
              _tmpCategoryLevel2 = _cursor.getString(_cursorIndexOfCategoryLevel2);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final String _tmpVideo;
            if (_cursor.isNull(_cursorIndexOfVideo)) {
              _tmpVideo = null;
            } else {
              _tmpVideo = _cursor.getString(_cursorIndexOfVideo);
            }
            _item = new FoodEntity(_tmpId,_tmpName,_tmpCategoryLevel1,_tmpCategoryLevel2,_tmpDescription,_tmpPhoto,_tmpVideo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<FoodEntity> getFoodById(final int id) {
    final String _sql = "SELECT * FROM food WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<FoodEntity>() {
      @Override
      public FoodEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategoryLevel1 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_1");
          final int _cursorIndexOfCategoryLevel2 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_2");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final FoodEntity _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategoryLevel1;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel1)) {
              _tmpCategoryLevel1 = null;
            } else {
              _tmpCategoryLevel1 = _cursor.getString(_cursorIndexOfCategoryLevel1);
            }
            final String _tmpCategoryLevel2;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel2)) {
              _tmpCategoryLevel2 = null;
            } else {
              _tmpCategoryLevel2 = _cursor.getString(_cursorIndexOfCategoryLevel2);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final String _tmpVideo;
            if (_cursor.isNull(_cursorIndexOfVideo)) {
              _tmpVideo = null;
            } else {
              _tmpVideo = _cursor.getString(_cursorIndexOfVideo);
            }
            _result = new FoodEntity(_tmpId,_tmpName,_tmpCategoryLevel1,_tmpCategoryLevel2,_tmpDescription,_tmpPhoto,_tmpVideo);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<FoodEntity>> getFullMenu() {
    final String _sql = "SELECT * FROM food ORDER BY category_1, name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<List<FoodEntity>>() {
      @Override
      public List<FoodEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategoryLevel1 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_1");
          final int _cursorIndexOfCategoryLevel2 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_2");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final List<FoodEntity> _result = new ArrayList<FoodEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FoodEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategoryLevel1;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel1)) {
              _tmpCategoryLevel1 = null;
            } else {
              _tmpCategoryLevel1 = _cursor.getString(_cursorIndexOfCategoryLevel1);
            }
            final String _tmpCategoryLevel2;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel2)) {
              _tmpCategoryLevel2 = null;
            } else {
              _tmpCategoryLevel2 = _cursor.getString(_cursorIndexOfCategoryLevel2);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final String _tmpVideo;
            if (_cursor.isNull(_cursorIndexOfVideo)) {
              _tmpVideo = null;
            } else {
              _tmpVideo = _cursor.getString(_cursorIndexOfVideo);
            }
            _item = new FoodEntity(_tmpId,_tmpName,_tmpCategoryLevel1,_tmpCategoryLevel2,_tmpDescription,_tmpPhoto,_tmpVideo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<FoodEntity>> getFoodsByIds(final List<Integer> ids) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM food WHERE id IN (");
    final int _inputSize = ids.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY name");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : ids) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<List<FoodEntity>>() {
      @Override
      public List<FoodEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategoryLevel1 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_1");
          final int _cursorIndexOfCategoryLevel2 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_2");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final List<FoodEntity> _result = new ArrayList<FoodEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FoodEntity _item_1;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategoryLevel1;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel1)) {
              _tmpCategoryLevel1 = null;
            } else {
              _tmpCategoryLevel1 = _cursor.getString(_cursorIndexOfCategoryLevel1);
            }
            final String _tmpCategoryLevel2;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel2)) {
              _tmpCategoryLevel2 = null;
            } else {
              _tmpCategoryLevel2 = _cursor.getString(_cursorIndexOfCategoryLevel2);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final String _tmpVideo;
            if (_cursor.isNull(_cursorIndexOfVideo)) {
              _tmpVideo = null;
            } else {
              _tmpVideo = _cursor.getString(_cursorIndexOfVideo);
            }
            _item_1 = new FoodEntity(_tmpId,_tmpName,_tmpCategoryLevel1,_tmpCategoryLevel2,_tmpDescription,_tmpPhoto,_tmpVideo);
            _result.add(_item_1);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<FoodEntity>> searchFoods(final String query) {
    final String _sql = "SELECT * FROM food WHERE name LIKE '%' || ? || '%' OR description LIKE '%' || ? || '%' OR category_1 LIKE '%' || ? || '%' OR category_2 LIKE '%' || ? || '%' ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 4;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<List<FoodEntity>>() {
      @Override
      public List<FoodEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategoryLevel1 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_1");
          final int _cursorIndexOfCategoryLevel2 = CursorUtil.getColumnIndexOrThrow(_cursor, "category_2");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final List<FoodEntity> _result = new ArrayList<FoodEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FoodEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategoryLevel1;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel1)) {
              _tmpCategoryLevel1 = null;
            } else {
              _tmpCategoryLevel1 = _cursor.getString(_cursorIndexOfCategoryLevel1);
            }
            final String _tmpCategoryLevel2;
            if (_cursor.isNull(_cursorIndexOfCategoryLevel2)) {
              _tmpCategoryLevel2 = null;
            } else {
              _tmpCategoryLevel2 = _cursor.getString(_cursorIndexOfCategoryLevel2);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final String _tmpVideo;
            if (_cursor.isNull(_cursorIndexOfVideo)) {
              _tmpVideo = null;
            } else {
              _tmpVideo = _cursor.getString(_cursorIndexOfVideo);
            }
            _item = new FoodEntity(_tmpId,_tmpName,_tmpCategoryLevel1,_tmpCategoryLevel2,_tmpDescription,_tmpPhoto,_tmpVideo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> countFoods() {
    final String _sql = "SELECT COUNT(*) FROM food";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> getFoodCount() {
    final String _sql = "SELECT COUNT(*) FROM food";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"food"}, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
