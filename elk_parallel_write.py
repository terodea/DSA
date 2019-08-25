from multiprocessing import Pool
from elasticsearch import Elasticsearch
import time


def task(body):
    result = es.index(index='test', doc_type='test', body=body)
    return result


def main():
    pool = Pool(processes=MAX_CONNECTS)
    result = []
    for x in range(10):
        result.append(pool.apply_async(task, ({'id': x},)))
    time.sleep(1)
    for rs in result:
        print(rs.get())


if __name__ == "__main__":
    MAX_CONNECTS = 5
    es = Elasticsearch(hosts="localhost", maxsize=MAX_CONNECTS)
    main()